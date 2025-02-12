package com.mohaberabi.devicekit.domain

fun interface DeviceKitFactory {
    fun create(): DeviceKit
}