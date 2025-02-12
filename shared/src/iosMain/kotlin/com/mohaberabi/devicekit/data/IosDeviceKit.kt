package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.DeviceKit
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSFileManager
import platform.Foundation.NSFileSystemFreeSize
import platform.Foundation.NSFileSystemSize
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSProcessInfo
import platform.Foundation.NSTimeZone
import platform.Foundation.systemTimeZone
import platform.UIKit.UIDevice
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.UIKit.UIUserInterfaceIdiomTV

class IosDeviceKit : DeviceKit {
    override val osName: String = "IOS"
    override val osVersionName: String = UIDevice.currentDevice.systemName
    override val osVersion: String = UIDevice.currentDevice.systemVersion
    override val appSize: Double = 0.0
    override val resolution: String = ""
    override val storageInfo: String = ""
    override val availableExternalStorageSize: Long? = null
    override val totalInternalStorageSize: Long = totalInternalStorage()
    override val availableInternalStorageSize: Long = availableInternalStorage()
    override val externalMemoryAvailable: Boolean = false
    override val mobileNetworkCode: String? = null
    override val mobileCountryCode: String? = null
    override val ramInfo: String = ""
    override val availableRam: Long = NSProcessInfo.processInfo.physicalMemory.toLong()
    override val totalRam: Long = NSProcessInfo.processInfo.physicalMemory.toLong()
    override val deviceName: String = UIDevice.currentDevice.name
    override val manufacturer: String = "Apple"
    override val cpuInfo: String = ""
    override val model: String = UIDevice.currentDevice.model
    override val uuid: String = UIDevice.currentDevice.identifierForVendor?.UUIDString ?: "Unknown"
    override val screenSize: String = getScreenSize()
    override val deviceTimeZone: String = NSTimeZone.systemTimeZone.name


}

internal fun getScreenSize(): String {
    val isIpad = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomPad
    val isTv = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomTV
    val isIphone = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomPhone
    return when {
        isIpad -> "I-Pad"
        isTv -> "Apple TV"
        isIphone -> "Iphone"
        else -> "Unknown"
    }
}


@OptIn(ExperimentalForeignApi::class)
internal fun totalInternalStorage(): Long {
    val fileManager = NSFileManager.defaultManager
    return fileManager.attributesOfFileSystemForPath(NSHomeDirectory(), null)
        ?.get(NSFileSystemSize) as? Long ?: 0L
}

@OptIn(ExperimentalForeignApi::class)
internal fun availableInternalStorage(): Long {
    val fileManager = NSFileManager.defaultManager
    return fileManager.attributesOfFileSystemForPath(NSHomeDirectory(), null)
        ?.get(NSFileSystemFreeSize) as? Long ?: 0L
}
