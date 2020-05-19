package com.nokia.xml.primitives

fun main(args: Array<String>) {
    val xmlA = XMLType.loadFromStringPath("src/test/resources/xmlA.xml")
    val xmlB = XMLType.loadFromStringPath("src/test/resources/xmlB.xml")

    val partialXmlA = XMLType.loadFromStringPath("src/test/resources/partialXmlA.xml")
    val partialXmlB = XMLType.loadFromStringPath("src/test/resources/partialXmlB.xml")

    val r = xmlB.mergeInto(xmlA)

    println("----------------")
    println(r)
    println(xmlA)
    println(xmlB)

    val xmlAT = xmlA.transform("src/test/resources/simpleTransformTest.xslt")
    println(xmlAT)

    /*val r2 = xmlA.mergeInto(xmlA)
    println("----------------")
    println(r2)
    println(xmlA)

    /*val f = partialXmlA.find("//bb")
    //println(f[0].getEl())

    val ml = MergeListener(onMerge = ::noReplaceOnMerge)
    val r3 = XMLType.mergeAllInto(partialXmlB, Merger(ml), *f.toTypedArray())
    println(r3)*/

    /*val abEls = partialXmlA.find("//ab")

    val m2 = MergeListener(onMerge = ::noReplaceOnMerge ,onGetPath = byAttributeOnGetPath("id"))
    val r4 = abEls.mergeAllInto(partialXmlB, Merger(m2))*/
    //val r4 = XMLType.mergeAllInto(partialXmlB, Merger(m2), *abEls.toTypedArray())
    //println(r4.pretty())

    val toex = xmlA.find("//bb")[0]
    val ex = toex.extract()
    println(ex.pretty())
    println(xmlA.pretty())*/
}