plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "dev.kavrin.liftflow"
version = "1.0.0"
application {
    mainClass.set("dev.kavrin.liftflow.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
//    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}