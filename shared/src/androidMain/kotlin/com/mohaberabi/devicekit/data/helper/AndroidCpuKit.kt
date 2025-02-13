package com.mohaberabi.devicekit.data.helper

import com.mohaberabi.devicekit.domain.CPUKit

internal class AndroidCpuKit : CPUKit {

    override val cpuInfo: String = ""
    override val cpuCores: Int = Runtime.getRuntime().availableProcessors()

}