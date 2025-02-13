package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.CPUKit
import platform.Foundation.NSProcessInfo


internal class IosCpuKit : CPUKit {
    override val cpuCores: Int = NSProcessInfo.processInfo.activeProcessorCount.toInt()
    override val cpuInfo: String = "CORES :${cpuCores}"

}