package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.BatteryKit
import com.mohaberabi.devicekit.domain.model.BatteryPower
import com.mohaberabi.devicekit.domain.model.DeviceThermal
import platform.Foundation.NSProcessInfo
import platform.Foundation.NSProcessInfoThermalState
import platform.Foundation.thermalState
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceBatteryState


internal class IosBatteryKit : BatteryKit {
    override val deviceThermal: String = NSProcessInfo.processInfo.thermalState().name
    override val batteryLevel: Int = UIDevice.currentDevice.batteryLevel.toInt()
    override val batteryTemperature: Double = -1.0
    override val batteryPower: BatteryPower
        get() {
            UIDevice.currentDevice.setBatteryMonitoringEnabled(true)
            return when (UIDevice.currentDevice.batteryState) {
                UIDeviceBatteryState.UIDeviceBatteryStateFull -> BatteryPower.Full
                UIDeviceBatteryState.UIDeviceBatteryStateCharging -> BatteryPower.Charging
                UIDeviceBatteryState.UIDeviceBatteryStateUnplugged -> BatteryPower.Unplugged
                else -> BatteryPower.Unknown
            }
        }
}