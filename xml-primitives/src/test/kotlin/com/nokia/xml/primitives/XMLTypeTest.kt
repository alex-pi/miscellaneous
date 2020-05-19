package com.nokia.xml.primitives

import io.kotlintest.*
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.sequences.containNoNulls
import io.kotlintest.matchers.string.beEmpty
import io.kotlintest.specs.ShouldSpec
import java.nio.file.Paths

class XMLTypeTest: ShouldSpec() {

    //private val xmlTypeA: XMLType
    private val pathToXmlA = Paths.get("src/test/resources/xmlA.xml")
    private val pathToXmlB = Paths.get("src/test/resources/xmlB.xml")
    private val pathToPartialXmlA = Paths.get("src/test/resources/partialXmlA.xml")
    private val pathToPartialXmlB = Paths.get("src/test/resources/partialXmlB.xml")
    private val pathToXmlMerge = Paths.get("src/test/resources/defaultMergeBIntoA.xml")
    private val pathToXmlATransformed = Paths.get("src/test/resources/defaultMergeBIntoA.xml")

    private val customMergeLister = MergeListener(onMerge = tagReplacesOnMerge("un"))
    private val customNoReplaceMergeLister = MergeListener (onMerge = ::noReplaceOnMerge , onGetPath = byAttributeOnGetPath("id"))

    private val pathToSimpleTransform = "src/test/resources/simpleTransformTest.xslt"

    init {

        "XMLType.loadFromPath for a valid XML" {
            val xmlTypeA = XMLType.loadFromPath(pathToXmlA)
            should("load correctly") {
                xmlTypeA shouldNotBe null
                xmlTypeA.element shouldNotBe null
                xmlTypeA.toString() shouldNot beEmpty()
            }
        }
        "XMLType.find tests" {
            val xmlTypeA = XMLType.loadFromPath(pathToXmlA)
            val found = xmlTypeA.find("//aa")
            should("return 2 occurrences for //aa"){
                found should haveSize(2)
                found.asSequence() should containNoNulls()
            }

            val notFound = xmlTypeA.find("//xyz")
            should("not return ocurrences for //xyz") {
                notFound shouldNotBe null
                notFound.shouldBeEmpty()
            }
        }

        "XMLType.mergeInto tests" {
            val xmlTypeA = XMLType.loadFromPath(pathToXmlA)
            val xmlTypeB = XMLType.loadFromPath(pathToXmlB)

            val xmlTypeAStrBefore = xmlTypeA.toString()
            val xmlTypeBStrBefore = xmlTypeB.toString()
            val result = xmlTypeB.mergeInto(xmlTypeA)

            "When merging B into A" {
                should("merge should be correct") {
                    result shouldNotBe null
                    result.element shouldNotBe null
                    result.toString() shouldNot beEmpty()
                    val expected = XMLType.loadFromPath(pathToXmlMerge)
                    (result.toString() == expected.toString()).shouldBeTrue()
                }
                should("not change A and B after merge") {
                    (xmlTypeAStrBefore == xmlTypeA.toString()).shouldBeTrue()
                    (xmlTypeBStrBefore == xmlTypeB.toString()).shouldBeTrue()
                }
            }

            "When merging the same XML into itself" {
                val xmlTypeA = XMLType.loadFromPath(pathToXmlA)
                val result = xmlTypeA.mergeInto(xmlTypeA)
                should ("result and used xml should look the same") {
                    (result == xmlTypeA).shouldBeTrue()
                }
            }
        }

        "XMLType.mergeInto tests with Custom Listeners" {
            val xmlTypeA = XMLType.loadFromPath(pathToXmlA)
            val xmlTypeB = XMLType.loadFromPath(pathToXmlB)
            val expected = XMLType.loadFromPath(Paths.get("src/test/resources/defaultMergeBIntoACustomMerger.xml"))

            val merger = Merger(customMergeLister)
            val result = xmlTypeB.mergeInto(xmlTypeA, merger)

            "When merging B into A" {
                should("merge should be correct") {
                    result shouldNotBe null
                    result.element shouldNotBe null
                    result.toString() shouldNot beEmpty()
                    (result.toString() == expected.toString()).shouldBeTrue()
                }
            }

            "When merging parts of A into B" {
                val xmlTypeA = XMLType.loadFromPath(pathToPartialXmlA)
                val xmlTypeB = XMLType.loadFromPath(pathToPartialXmlB)
                val expected = XMLType.loadFromPath(Paths.get("src/test/resources/noReplaceMergerPartialAIntoB.xml"))

                val merger = Merger(customNoReplaceMergeLister)
                val parts = xmlTypeA.find("//ab")
                val result = parts.mergeAllInto(xmlTypeB, merger)

                should("merge should be correct") {
                    result shouldNotBe null
                    result.element shouldNotBe null
                    result.toString() shouldNot beEmpty()
                    (result.toString() == expected.toString()).shouldBeTrue()
                }
            }
        }

        "XMLType.transform must remove all <aa> elements" {
            val xmlTypeA = XMLType.loadFromPath(pathToXmlA)
            val result = xmlTypeA.transform(pathToSimpleTransform)
            val expected = XMLType.loadFromPath(Paths.get("src/test/resources/defaultMergeBIntoA.xml"))


        }
    }

/*    //@Test
    fun testLoadFromPath() {
        xmlTypeA.shouldNotBeNull()
        xmlTypeA.toString().shouldContain("<aa>")

    }

    //@Test
    fun `test find for two elements`() {
        val els = xmlTypeA.find("//aa")
        assertAll("xpath //aa",
            { assertNotNull(els) },
            { assertEquals(2, els.size) }
        )
    }

    //@Test
    fun testToString() {
        val str = xmlTypeA.toString()
        assertNotNull(str)
    }

    //@Test
    fun testSimpleMerge() {
        val xmlTypeB = XMLType.loadFromPath(pathToXmlB)
        xmlTypeB.mergeInto(xmlTypeA)
        println(xmlTypeA)
    }*/
}