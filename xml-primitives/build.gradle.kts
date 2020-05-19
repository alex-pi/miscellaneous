import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.50"
    id("com.gradle.build-scan") version "1.16"
    id("io.kotlintest") version "1.1.1"
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
}

group = "com.nokia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    /*maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }*/
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    //testCompile("org.jetbrains.kotlin", "kotlin-test-junit5", "1.3.50")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.3.2")
    //testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    //testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    // https://mvnrepository.com/artifact/org.jdom/jdom2
    implementation(group = "org.jdom", name = "jdom2", version = "2.0.6")
    implementation("jaxen:jaxen:1.2.0")
    implementation("io.github.microutils", "kotlin-logging", "1.7.6")
    implementation("org.slf4j", "slf4j-api", "1.7.25")
    implementation("org.slf4j", "slf4j-log4j12", "1.7.25")
    implementation("log4j", "log4j", "1.2.17")

    compileClasspath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.41")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.named<Test>("test") {
    useJUnitPlatform()
}