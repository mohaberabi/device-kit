package com.mohaberabi.devicekit.data

import android.content.Context
import com.mohaberabi.devicekit.domain.DeviceKit

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DefaultDeviceKit(
    private val context: Context
) : DeviceKit {
    override val osName: String = "Android"
    override val osVersionName: String = ""
    override val osVersion: String = ""
    override val appSize: Double = 0.0
    override val resolution: String = ""
    override val storageInfo: String = ""
    override val availableExternalStorageSize: Long? = null
    override val totalInternalStorageSize: Long = 0L
    override val availableInternalStorageSize: Long = 0L
    override val externalMemoryAvailable: Boolean = false
    override val mobileNetworkCode: String? = null
    override val mobileCountryCode: String? = null
    override val ramInfo: String = ""
    override val availableRam: Long = 0L
    override val totalRam: Long = 0L
    override val deviceName: String = ""
    override val manufacturer: String = "Apple"
    override val cpuInfo: String = ""
    override val model: String = ""
    override val uuid: String = ""
    override val screenSize: String = ""
    override val deviceTimeZone: String = ""
}