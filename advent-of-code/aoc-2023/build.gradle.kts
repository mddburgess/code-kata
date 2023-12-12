plugins {
    kotlin("jvm") version "1.9.21"
}

group = "dev.mikeburgess.adventofcode"
version = "2023-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
