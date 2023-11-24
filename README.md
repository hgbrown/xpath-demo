# Common approaches for testing XML

Although most popular APIs these days return JSON responses, there are still a lot of older APIs that return XML.
When this happens, I can't use [JsonPath](https://github.com/json-path/JsonPath) to test the response.
As a result I have come up with a few different approaches to solve this problem.

## Approach 1: Rest Assured XML Path

Primarily used for testing RESTful APIs, Rest Assured also includes capabilities for working with XML responses, including support for XMLPath, which is similar to JSONPath but for XML.
This approach is particularly useful when you are already using Rest Assured for testing your API.
Unlike the other approaches, I always have to remember to not use **XPath** expressions for selecting values.
Instead, the XMLPath expressions use dots and is further described here: http://www.groovy-lang.org/processing-xml.html#_simply_traversing_the_tree

For an example of this approach see: [RestAssuredXmlPathBasedTest](src/test/kotlin/dev/hbrown/RestAssuredXmlPathBasedTest.kt) 

## Approach 2: XMLUnit

This is a popular library for testing XML which allows you to compare and validate XML in various ways, including using XPath expressions. 
XMLUnit is a great choice if you're looking to perform detailed XML comparisons and validations in your tests.

For an example of this approach see: [XmlUnitXPathTest](src/test/kotlin/dev/hbrown/XmlUnitXPathTest.kt) 

## Approach 3: Standard XPath with some help from custom extension functions

Sometimes, especially when I am not testing an API, I don't want to include additional dependencies in my project.
This makes the first 2 approaches less desirable. In this case, I have developed a set of custom extension functions that I can use in my XPath expressions.

For an example of this approach see: [XmlDataSourceTest](src/test/kotlin/dev/hbrown/XmlDataSourceTest.kt) and [TestExtensions](src/test/kotlin/dev/hbrown/TestExtensions.kt) for the extension functions.
