package com.nokia.xml.primitives

import com.nokia.xml.resources.util.DefaultResourceLoader
import com.nokia.xml.resources.util.ResourceLoader
import mu.KotlinLogging
import org.jdom2.Document
import org.jdom2.Element
import org.jdom2.filter.Filters
import org.jdom2.input.SAXBuilder
import org.jdom2.output.Format.getCompactFormat
import org.jdom2.xpath.XPathFactory
import java.io.FileInputStream
import java.nio.file.Path
import org.jdom2.output.Format.getPrettyFormat
import org.jdom2.output.XMLOutputter
import org.jdom2.transform.XSLTransformer
import java.io.InputStream
import java.io.StringReader
import java.nio.file.Paths


class XMLType(val element: Element) {

    private val logger = KotlinLogging.logger {}

    //lateinit var doc: Document

    fun getEl(): Element = this.element

    fun clone(): XMLType = XMLType(this.getEl().document.clone().rootElement)

    fun find(xpath: String): List<XMLType> {
        val elements = ElementFinder.find(this.element, xpath)
        return elements.map { XMLType(it) }
    }

    fun mergeInto(target: XMLType, merger: Merger = Merger()) : XMLType {

        val cloned = target.clone()
        merger.merge(cloned, this)

        return cloned
    }

    fun pretty(): String {
        val xmlOutputter = XMLOutputter(getPrettyFormat())
        return xmlOutputter.outputString(this.element.document)
    }

    fun extract(root: String = "root"): XMLType {
        val cloned = this.element.clone()
        val rootEl = builder.build(StringReader("<${root}></$root>")).rootElement
        rootEl.addContent(cloned)
        return XMLType(rootEl)
    }

    fun transform(xslt: String): XMLType {
        val inputStream = loader.load(xslt)
        val transformer = XSLTransformer(inputStream)
        val newDoc = transformer.transform(this.element.document)

        return XMLType(newDoc.rootElement)
    }

    override fun toString(): String {
        val xmlOutputter = XMLOutputter(getCompactFormat())
        return xmlOutputter.outputString(this.element.document).trim()
    }

    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }

    companion object {

        private val builder = SAXBuilder()

        private val loader = DefaultResourceLoader<Any, InputStream>()

        fun loadFromPath(source: Path): XMLType {

            val fis = loader.load(source)
            val doc = fis.use { builder.build(fis) }

            return XMLType(doc.rootElement)
        }

        fun loadFromStringPath(source: String): XMLType {
            return loadFromPath(Paths.get(source))
        }

        fun loadFromString(source: String): XMLType {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        }
    }
}

fun Collection<XMLType>.mergeAllInto(target: XMLType, merger: Merger = Merger()): XMLType {
    val cloned = target.clone()
    this.map { s ->
        merger.merge(cloned, s)
    }

    return cloned
}

object ElementFinder {

    private val logger = KotlinLogging.logger {}

    private val xFactory = XPathFactory.instance()

    fun find(context: Element, xPathExpression: String): List<Element> {
        val expr = xFactory.compile(
            xPathExpression,
            Filters.element()
        )
        return expr.evaluate(context)
    }
}
