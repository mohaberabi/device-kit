package com.mohaberabi.devicekit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform