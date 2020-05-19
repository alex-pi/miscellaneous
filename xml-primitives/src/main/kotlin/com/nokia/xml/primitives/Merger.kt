package com.nokia.xml.primitives

import mu.KotlinLogging
import org.jdom2.Element
import org.jdom2.xpath.XPathHelper

class Merger(private val eventsListener: MergeListener = MergeListener()) {

    private val logger = KotlinLogging.logger {}

    fun merge(target: XMLType, source: XMLType) {
        recursiveMerge(target, source)
    }

    private fun recursiveMerge(target: XMLType, source: XMLType,
                              sourcePath: String =
                                  eventsListener.onGetPath(source.element.document.rootElement, source.element, null)) {
        //val targetEl = target.element
        val sourceEl = source.element
        //val parentXPath = eventsListener.onGetPath(sourceEl)

        fun mergeElement(el: Element, currentElXPath: String = eventsListener.onGetPath(null, el, sourcePath)) {
            //val currentElXPath = eventsListener.onGetPath(null, el, sourcePath)
            logger.debug { "****************************" }
            logger.debug { "Name: ${el.name}" }
            logger.debug { "CType: ${el.cType}" }
            logger.debug { "hasAtts: ${el.hasAttributes()}" }
            logger.debug { "Atts: ${el.attributes}" }
            logger.debug { "Text: ${el.text}" }
            logger.debug { "XPath: $currentElXPath" }

            val foundInTarget = target.find(currentElXPath).map { it.element }
            when {
                foundInTarget.isNullOrEmpty() -> {
                    logger.debug { "Not found in target: $currentElXPath" }
                    val parentInTarget = target.find(sourcePath).getOrNull(0)
                    //only if there is a parent where we can insert
                    parentInTarget?.let {
                        eventsListener.onTargetAbsence(parentInTarget.element, el)
                    }
                }
                else -> {
                    logger.debug { "Found in target: $currentElXPath" }
                    val selectedInTarget = eventsListener.onTargetFound(foundInTarget, el)
                    if(!eventsListener.onMerge(selectedInTarget, el))
                        recursiveMerge(target, XMLType(el), currentElXPath)
                }
            }

        }

        for(el in sourceEl.children) {
            mergeElement(el)
        }

        if(sourceEl.children.isNullOrEmpty()){
            mergeElement(sourceEl, sourcePath)
        }
    }
}

typealias Merge = (Element, Element) -> Boolean
typealias TargetAbsence = (Element, Element) -> Unit
typealias TargetFound = (List<Element>, Element) -> Element
typealias GetPath = (Element?, Element, String?) -> String

class MergeListener(var onMerge: Merge = ::defaultOnMerge,
                    var onTargetAbsence: TargetAbsence = ::defaultOnTargetAbsence,
                    var onTargetFound: TargetFound = ::defaultOnTargetFound,
                    var onGetPath: GetPath = ::defaultOnGetPath)

fun defaultOnMerge(elInTarget: Element, elInSource: Element): Boolean {
    elInSource.attributes.forEach { elInTarget.setAttribute(it.clone()) }
    var solved = false
    when {
        !elInSource.text.isNullOrBlank() && elInSource.children.isNullOrEmpty() -> {
            elInTarget.text = String(elInSource.text.toByteArray())
            println("${elInSource.text === elInTarget.text}")
            solved = true
        }
        elInSource.text.isNullOrBlank() && elInSource.children.isNullOrEmpty() -> {
            elInTarget.removeContent()
            solved = true
        }
    }
    return solved
}

fun defaultOnTargetAbsence(parentInTarget: Element, elInSource: Element) {
    parentInTarget.addContent(elInSource.clone())
}

fun defaultOnTargetFound(elements: List<Element>, element: Element): Element = elements[0]

fun defaultOnGetPath(from: Element?, to: Element, basePath: String? = null): String {
    return if (from != null)
        XPathHelper.getRelativePath(from, to)
    else
        XPathHelper.getAbsolutePath(to)
}

fun noReplaceOnMerge(elInTarget: Element, elInSource: Element): Boolean {
    //When the element only contains text, do not replace it, just keep it as is
    return (!elInSource.text.isNullOrBlank() || elInSource.text.isNullOrBlank())
        && elInSource.children.isNullOrEmpty()
}

fun tagReplacesOnMerge(tagName: String): Merge {
    return { elInTarget, elInSource ->
            val specialTag = elInSource.children.find { it.name == tagName }
            var solved = false
            specialTag?.let {
                elInTarget.setContent(it.clone())
                solved = true
            }
            if (!solved)
                defaultOnMerge(elInTarget, elInSource)
            else solved
    }
}

fun usePredicateOnTargetFound(predicate: (Element, Element) -> Boolean): TargetFound {
    return { candidates, elBase ->
        candidates.first {
            predicate(it, elBase)
        }
    }
}

fun byAttributePredicate(attrName: String): (Element, Element) -> Boolean {
    return { candidate, base ->
        candidate.getAttributeValue(attrName) == base.getAttributeValue(attrName)
    }
}

fun byAttributeOnTargetFound(attrName: String): TargetFound {
    return usePredicateOnTargetFound(byAttributePredicate(attrName))
}

fun byAttributeOnGetPath(attrName: String): GetPath {
    return { from, to, basePath ->

        //first produce a path by calling the util or appending to basePath
        //then append the propPath if applies
        var path = when {
            !basePath.isNullOrEmpty() -> {
                "${basePath}/${to.name}"
            }
            else -> {
                defaultOnGetPath(from, to)
            }
        }

        if(to.attributes.any { att -> att.name == attrName }) {
            val propPath = "[@${attrName}='${to.getAttribute(attrName).value}']"
            //var path = defaultOnGetPath(from, to)
            if (path.last() == ']') { //if path is positional
                val lastIdx = path.lastIndexOf('[')
                path = path.replaceRange(lastIdx..path.lastIndex, propPath)
            } else path ="$path$propPath"
        }
        path
    }
}
