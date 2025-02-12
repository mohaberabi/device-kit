package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.DeviceKit
import com.mohaberabi.devicekit.domain.DeviceKitFactory

class IosDeviceKitFactory : DeviceKitFactory {
    override fun create(): DeviceKit = IosDeviceKit()
}