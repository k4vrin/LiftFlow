rootProject.name = "LiftFlow"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

private fun subprojects(path: String): List<String> {
    return file(path)
        .listFiles()
        ?.filter {
            it.isDirectory && !it.listFiles().isNullOrEmpty() && it.listFiles().any { file -> file.name == "build.gradle.kts" }
        }?.map {
            "${path.replace('/', ':')}:${it.name}"
        } ?: emptyList()
}


include(":composeApp")
include(":server")
include(":shared")
include(subprojects("core"))
include(subprojects("data"))
include(subprojects("data/workout"))
include(subprojects("domain"))
include(subprojects("domain/workout"))
include(subprojects("feature"))
include(subprojects("feature/workout"))
//include(":myapplication")
