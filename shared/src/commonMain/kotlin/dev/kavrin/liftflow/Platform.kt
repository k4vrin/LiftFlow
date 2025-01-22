package dev.kavrin.liftflow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform