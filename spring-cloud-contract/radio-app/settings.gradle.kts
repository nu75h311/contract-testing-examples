rootProject.name = "radio-app"
pluginManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://repo.spring.io/release") }
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        gradlePluginPortal()
    }
    plugins {
        val springBootVersion: String by settings
        id("org.springframework.boot") version springBootVersion
    }
}