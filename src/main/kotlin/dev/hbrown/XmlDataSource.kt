package dev.hbrown

class XmlDataSource {

    fun person(): String = """
        <person>
            <name>
                <first>John</first>
                <last>Doe</last>
            </name>
            <age>21</age>
            <id>1234</id>
        </person>
    """.trimIndent()

    fun messages(): String = """
        <messages>
            <message>
                <from>John</from>
                <to>Jane</to>
                <body>Hello, Jane!</body>
            </message>
            <message>
                <from>Jane</from>
                <to>John</to>
                <body>Hello, John!</body>
            </message>
        </messages>
    """.trimIndent()
}
