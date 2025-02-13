package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.InfoKit
import platform.Foundation.NSTimeZone
import platform.Foundation.systemTimeZone
import platform.UIKit.UIDevice


internal class IosInfoKit : InfoKit {
    override val manufacturer: String = "Apple"
    override val deviceName: String = UIDevice.currentDevice.name
    override val model: String = UIDevice.currentDevice.model
    override val uuid: String = UIDevice.currentDevice.identifierForVendor?.UUIDString ?: "Unknown"
    override val osName: String = "IOS"
    override val osVersionName: String = UIDevice.currentDevice.systemName
    override val osVersion: String = UIDevice.currentDevice.systemVersion
    override val appSize: Double = 0.0
    override val deviceTimeZone: String = NSTimeZone.systemTimeZone.name
}