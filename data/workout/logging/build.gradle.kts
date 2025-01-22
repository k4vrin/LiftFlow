plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget()
    jvm("desktop") // For desktop compose

    sourceSets {
        commonMain.dependencies {
//            implementation(libs.kotlin.coroutines) // From version catalog
            // Add other shared dependencies
        }
    }
}

android {
    namespace = "dev.kavrin.liftflow.data.workout.logging"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
}