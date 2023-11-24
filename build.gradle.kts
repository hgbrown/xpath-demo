plugins {
    kotlin("jvm") version "1.9.21"
}

group = "dev.hbrown"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.24.2")

    testImplementation("javax.xml.bind:jaxb-api:2.3.1")
    testImplementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")

    testImplementation("io.rest-assured:rest-assured:5.3.2")

    testImplementation("org.xmlunit:xmlunit-core:2.9.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
