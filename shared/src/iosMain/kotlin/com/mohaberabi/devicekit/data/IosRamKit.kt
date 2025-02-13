package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.RAMKit
import platform.Foundation.NSProcessInfo

internal class IosRamKit : RAMKit {
    override val ramInfo: String = ""
    override val availableRam: Long = NSProcessInfo.processInfo.physicalMemory.toLong()
    override val totalRam: Long = NSProcessInfo.processInfo.physicalMemory.toLong()
}