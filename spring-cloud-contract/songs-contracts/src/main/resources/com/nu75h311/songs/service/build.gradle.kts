import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.cloud.contract") version "3.1.3"
    id("maven-publish")
    kotlin("jvm") version "1.5.30"
    kotlin("plugin.spring") version "1.5.30"
}

group = "com.nu75h311"
version = "0.0.1-SNAPSHOT" // not a stub of an official version
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencyManagement {

    val springCloudVersion: String by project

    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
}

contracts {
    contractsDslDir.set(project.file("${project.projectDir}/contracts"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifact(tasks.named("verifierStubsJar"))
        }
    }
}