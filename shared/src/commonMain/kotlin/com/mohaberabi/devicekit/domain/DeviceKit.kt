package com.mohaberabi.devicekit.domain

import com.mohaberabi.devicekit.domain.model.BatteryPower

interface DeviceKit {


    val ram: RAMKit
    val cellular: CellKit
    val gpu: GPUKit
    val cpu: CPUKit
    val info: InfoKit
    val storage: StorageKit
    val battery: BatteryKit
}


interface CellKit {
    val mobileNetworkCode: String?
    val mobileCountryCode: String?

}

interface CPUKit {
    val cpuInfo: String
    val cpuCores: Int
}

interface GPUKit {
    val gpuInfo: String
    val resolution: String
    val screenDensity: Float
    val refreshRate: Float
    val screenSize: String

}

interface InfoKit {
    val deviceName: String
    val manufacturer: String
    val osName: String
    val osVersionName: String
    val osVersion: String
    val appSize: Double
    val model: String
    val deviceTimeZone: String
    val uuid: String

}

interface StorageKit {
    val storageInfo: String
    val availableExternalStorageSize: Long?
    val totalInternalStorageSize: Long
    val availableInternalStorageSize: Long
    val externalStorageAvailable: Boolean

}

interface RAMKit {
    val ramInfo: String
    val availableRam: Long
    val totalRam: Long
}

interface BatteryKit {
    val deviceThermal: String
    val batteryLevel: Int
    val batteryTemperature: Double
    val batteryPower: BatteryPower
}