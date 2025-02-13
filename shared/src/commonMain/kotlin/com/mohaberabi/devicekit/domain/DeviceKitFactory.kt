package com.mohaberabi.devicekit.domain

fun interface DeviceKitFactory {
    fun create(): DeviceKit
}


fun provideDeviceKit(factory: DeviceKitFactory) = factory.create()