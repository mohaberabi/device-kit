package com.mohaberabi.devicekit.data

import android.content.Context
import com.mohaberabi.devicekit.domain.DeviceKit
import com.mohaberabi.devicekit.domain.DeviceKitFactory

class AndroidDeviceKitFactory(
    private val context: Context
) : DeviceKitFactory {
    override fun create(): DeviceKit {
        return AndroidDeviceKit(context.applicationContext)
    }
}