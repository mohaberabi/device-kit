package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import androidx.core.content.getSystemService
import com.mohaberabi.devicekit.domain.BatteryKit
import com.mohaberabi.devicekit.domain.model.BatteryPower

class AndroidBatteryKit(
    override val deviceThermal: String,
    override val batteryLevel: Int,
    override val batteryTemperature: Double,
    override val batteryPower: BatteryPower
) : BatteryKit


internal fun Context.getBatteryHealth() =
    with(requireNotNull(getSystemService<BatteryManager>())) { getBatteryHealth() }

internal fun Context.getBatteryLevel() =
    with(requireNotNull(getSystemService<BatteryManager>())) { getBatteryLevel() }

internal fun Context.getBatteryPower(): BatteryPower {
    val intent = registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    val status = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)

    return when (status) {
        BatteryManager.BATTERY_STATUS_CHARGING -> BatteryPower.Charging
        BatteryManager.BATTERY_STATUS_FULL -> BatteryPower.Full
        BatteryManager.BATTERY_STATUS_DISCHARGING,
        BatteryManager.BATTERY_STATUS_NOT_CHARGING -> BatteryPower.Unplugged

        else -> BatteryPower.Unknown
    }
}

internal fun BatteryManager.getBatteryHealth(): String {
    if (Build.VERSION.SDK_INT < 26) return "Unknown"
    val healthStatus = getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS)
    return when (healthStatus) {
        BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
        BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
        BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
        BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
        BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Failure"
        BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
        else -> "Unknown"
    }
}

internal fun BatteryManager.getBatteryLevel() =
    getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

internal fun Context.getBatteryCelsius(): Double {
    val intent = registerReceiver(
        null,
        android.content.IntentFilter(android.content.Intent.ACTION_BATTERY_CHANGED)
    )
    val temp = intent?.getIntExtra("temperature", 0) ?: 0
    return temp / 10.0
}
