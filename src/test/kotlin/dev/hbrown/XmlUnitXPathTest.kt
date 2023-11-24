package dev.hbrown

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.w3c.dom.Node
import org.xmlunit.builder.Input.fromString
import org.xmlunit.xpath.JAXPXPathEngine

class XmlUnitXPathTest {
    private val cut = XmlDataSource()
    private val xpathEngine = JAXPXPathEngine()

    @Test
    fun `should be able to get individual nodes in person`() {
        val xml = cut.person()

        assertThat(xml["//person/name/first"].first()).isEqualTo("John")
        assertThat(xml["//person/name/last"].first()).isEqualTo("Doe")
        assertThat(xml["//person/age"].first()).isEqualTo("21")
        assertThat(xml["//person/id"].first()).isEqualTo("1234")
    }

    @Test
    fun `should be able to get messages stuff`() {
        val xml = cut.messages()

        assertThat(xml["//messages/message/body"]).containsExactly("Hello, Jane!", "Hello, John!")
    }

    private operator fun String.get(expression: String): List<String> {
        val node: MutableIterable<Node> = xpathEngine.selectNodes(expression, fromString(this).build())
        return node.map { it.textContent.trim() }
    }
}
