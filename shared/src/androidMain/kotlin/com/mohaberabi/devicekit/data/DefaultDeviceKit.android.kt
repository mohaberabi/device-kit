package com.mohaberabi.devicekit.data

import android.content.Context
import android.icu.util.Calendar
import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import android.os.Build.VERSION
import com.mohaberabi.devicekit.data.helper.availableExternalStorageSize
import com.mohaberabi.devicekit.data.helper.availableInternalStorageSize
import com.mohaberabi.devicekit.data.helper.availableRam
import com.mohaberabi.devicekit.data.helper.getAppSize
import com.mohaberabi.devicekit.data.helper.getTotalRam
import com.mohaberabi.devicekit.data.helper.isExternalStorageAvailable
import com.mohaberabi.devicekit.data.helper.mobileCountryCode
import com.mohaberabi.devicekit.data.helper.mobileNetworkCode
import com.mohaberabi.devicekit.data.helper.totalInternalStorageSize
import com.mohaberabi.devicekit.domain.DeviceKit
import device_info.mapVersionCodeToName

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DefaultDeviceKit(
    private val context: Context
) : DeviceKit {


    override val osName: String = "Android"
    override val osVersion: String = VERSION.RELEASE

    private val releaseText =
        osVersion.replace("(\\d+[.]\\d+)(.*)", "$1").toDoubleOrNull() ?: 0.0
    override val osVersionName: String = releaseText.mapVersionCodeToName()

    override val appSize: Double = context.getAppSize()
    override val resolution: String = ""
    override val storageInfo: String = ""
    override val availableExternalStorageSize: Long? = context.availableExternalStorageSize()
    override val totalInternalStorageSize: Long = totalInternalStorageSize()
    override val availableInternalStorageSize: Long = availableInternalStorageSize()
    override val externalMemoryAvailable: Boolean = isExternalStorageAvailable
    override val mobileNetworkCode: String? = context.mobileNetworkCode()
    override val mobileCountryCode: String? = context.mobileCountryCode()
    override val availableRam: Long = context.availableRam()
    override val totalRam: Long = context.getTotalRam()
    override val ramInfo: String = "Available:${availableRam} MB\\nTotal:${totalRam} MB\""
    override val deviceName: String = ""
    override val manufacturer: String = MANUFACTURER
    override val cpuInfo: String = ""
    override val model: String = MODEL
    override val uuid: String = ""
    override val screenSize: String = ""
    override val deviceTimeZone: String = Calendar.getInstance().timeZone.displayName
}