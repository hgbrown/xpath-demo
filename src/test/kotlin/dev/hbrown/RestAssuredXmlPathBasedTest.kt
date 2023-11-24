package dev.hbrown

import io.restassured.path.xml.XmlPath
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RestAssuredXmlPathBasedTest {

    private val cut = XmlDataSource()

    @Test
    fun `should be able to get individual nodes in person`() {
        val xml = cut.person()
        val xmlPath = XmlPath(xml)

        assertThat(xmlPath.getString("person.name.first")).isEqualTo("John")
        assertThat(xmlPath.getString("person.name.last")).isEqualTo("Doe")
        assertThat(xmlPath.getInt("person.age")).isEqualTo(21)
        assertThat(xmlPath.getInt("person.id")).isEqualTo(1234)
    }

    @Test
    fun `should be able to get messages stuff`() {
        val xml = cut.messages()
        val xmlPath = XmlPath(xml)

        assertThat(xmlPath.getList<String>("messages.message.body")).containsExactly("Hello, Jane!", "Hello, John!")
    }
}
