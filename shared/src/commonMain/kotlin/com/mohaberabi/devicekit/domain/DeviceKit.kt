package com.mohaberabi.devicekit.domain

interface DeviceKit {

    val osName: String
    val osVersionName: String
    val osVersion: String
    val appSize: Double
    val resolution: String
    val storageInfo: String
    val availableExternalStorageSize: Long?
    val totalInternalStorageSize: Long
    val availableInternalStorageSize: Long
    val externalMemoryAvailable: Boolean
    val mobileNetworkCode: String?
    val mobileCountryCode: String?
    val ramInfo: String
    val availableRam: Long
    val totalRam: Long
    val deviceName: String
    val manufacturer: String
    val cpuInfo: String
    val model: String
    val uuid: String
    val screenSize: String
    val deviceTimeZone: String

}