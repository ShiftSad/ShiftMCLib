plugins {
    kotlin("jvm") version "1.8.0"
    `maven-publish`
}

group = "tech.shiftmc.lib"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Dependencies available in all modules
dependencies {
    // API Kotlin
    subprojects {
        // Dependencies inherited by all submodules
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.20")
    }
}

kotlin {
    jvmToolchain(17)
}
