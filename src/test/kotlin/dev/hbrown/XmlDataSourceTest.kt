package dev.hbrown

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class XmlDataSourceTest {

    private val cut = XmlDataSource()

    @Test
    fun `should be able to get individual nodes in person`() {
        val document = cut.person().toXmlDocument()

        assertThat(document["//person/name/first"].first()).isEqualTo("John")
        assertThat(document["//person/name/last"].first()).isEqualTo("Doe")
        assertThat(document["//person/age"].first()).isEqualTo("21")
        assertThat(document["//person/id"].first()).isEqualTo("1234")
    }

    @Test
    fun `should be able to get messages stuff`() {
        val document = cut.messages().toXmlDocument()

        assertThat(document["//messages/message/body"]).containsExactly("Hello, Jane!", "Hello, John!")
    }
}
