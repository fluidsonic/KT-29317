import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.20-eap-100"
}

group = "fluidsonic"
version = "1"

repositories {
    bintray("kotlin/kotlin-eap")
    bintray("kotlin/kotlinx")
    bintray("kotlin/ktor")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-netty:1.1.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


fun RepositoryHandler.bintray(name: String) =
    maven("https://dl.bintray.com/$name")
