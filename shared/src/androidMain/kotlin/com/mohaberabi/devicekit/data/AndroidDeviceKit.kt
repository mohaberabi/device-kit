package com.mohaberabi.devicekit.data

import android.content.Context
import android.icu.util.Calendar
import android.opengl.GLES20
import android.os.Build
import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import android.os.Build.VERSION
import com.mohaberabi.devicekit.data.helper.AndroidBatteryKit
import com.mohaberabi.devicekit.data.helper.AndroidCpuKit
import com.mohaberabi.devicekit.data.helper.AndroidGpuKit
import com.mohaberabi.devicekit.data.helper.AndroidInfoKit
import com.mohaberabi.devicekit.data.helper.AndroidRAMKit
import com.mohaberabi.devicekit.data.helper.AndroidStorageKit
import com.mohaberabi.devicekit.data.helper.AndroidcellularKit
import com.mohaberabi.devicekit.data.helper.availableExternalStorageSize
import com.mohaberabi.devicekit.data.helper.availableInternalStorageSize
import com.mohaberabi.devicekit.data.helper.availableRam
import com.mohaberabi.devicekit.data.helper.deviceResolution
import com.mohaberabi.devicekit.data.helper.getAppSize
import com.mohaberabi.devicekit.data.helper.getBatteryCelsius
import com.mohaberabi.devicekit.data.helper.getBatteryHealth
import com.mohaberabi.devicekit.data.helper.getBatteryLevel
import com.mohaberabi.devicekit.data.helper.getBatteryPower
import com.mohaberabi.devicekit.data.helper.getScreenSize
import com.mohaberabi.devicekit.data.helper.getTotalRam
import com.mohaberabi.devicekit.data.helper.isExternalStorageAvailable
import com.mohaberabi.devicekit.data.helper.mobileCountryCode
import com.mohaberabi.devicekit.data.helper.mobileNetworkCode
import com.mohaberabi.devicekit.data.helper.totalInternalStorageSize
import com.mohaberabi.devicekit.domain.BatteryKit
import com.mohaberabi.devicekit.domain.CPUKit
import com.mohaberabi.devicekit.domain.CellKit
import com.mohaberabi.devicekit.domain.DeviceKit
import com.mohaberabi.devicekit.domain.GPUKit
import com.mohaberabi.devicekit.domain.InfoKit
import com.mohaberabi.devicekit.domain.RAMKit
import com.mohaberabi.devicekit.domain.StorageKit

internal class AndroidDeviceKit(
    context: Context,
) : DeviceKit {


    override val storage: StorageKit = AndroidStorageKit(
        availableExternal = context.availableExternalStorageSize(),
    )
    override val info: InfoKit = AndroidInfoKit(
        appSize = context.getAppSize(),
    )

    override val gpu: GPUKit = AndroidGpuKit(
        density = context.resources.displayMetrics.densityDpi.toFloat(),
        rateOfRefresh = if (Build.VERSION.SDK_INT >= 30) context.display.refreshRate else 0f,
        resolution = context.deviceResolution(),
        screenSize = context.getScreenSize()
    )
    override val ram: RAMKit = AndroidRAMKit(
        availableRam = context.availableRam(),
        totalRam = context.getTotalRam()
    )
    override val cellular: CellKit = AndroidcellularKit(
        mobileNetworkCode = context.mobileNetworkCode(),
        mobileCountryCode = context.mobileCountryCode()
    )

    override val battery: BatteryKit = AndroidBatteryKit(
        batteryTemperature = context.getBatteryCelsius(),
        batteryLevel = context.getBatteryLevel(),
        batteryPower = context.getBatteryPower(),
        deviceThermal = context.getBatteryHealth()
    )

    override val cpu: CPUKit = AndroidCpuKit()

}