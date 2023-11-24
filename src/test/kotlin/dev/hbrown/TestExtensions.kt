package dev.hbrown

import org.w3c.dom.Document
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

internal fun String.toXmlDocument(): Document {
    val dbFactory = DocumentBuilderFactory.newInstance()
    val dBuilder = dbFactory.newDocumentBuilder()
    return dBuilder.parse(this.byteInputStream())
}

internal fun Document.evaluate(expression: String): List<String> {
    val xpFactory = XPathFactory.newInstance()
    val xPath = xpFactory.newXPath()
    val nodeList = xPath.compile(expression).evaluate(this, XPathConstants.NODESET) as NodeList
    return (0..<nodeList.length).map { nodeList.item(it).textContent.trim() }
}

internal operator fun Document.get(expression: String): List<String> = evaluate(expression)
