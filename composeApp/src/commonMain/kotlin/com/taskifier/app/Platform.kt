package com.taskifier.app


interface Platform {
    val name: String
}

expect fun getPlatform(): Platform