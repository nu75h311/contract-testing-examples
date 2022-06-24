rootProject.name = "songs-service"
pluginManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://repo.spring.io/release") }
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        gradlePluginPortal()
    }
    resolutionStrategy {
        val springBootVersion: String by settings
        val springCloudContractVerifierVersion: String by settings
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
            }
            if (requested.id.id == "org.springframework.cloud.contract") {
                useModule("org.springframework.cloud:spring-cloud-contract-gradle-plugin:$springCloudContractVerifierVersion")
            }
        }
    }
}
