package com.mohaberabi.devicekit.data.helper

import android.app.ActivityManager
import android.content.Context
import androidx.core.content.getSystemService
import com.mohaberabi.devicekit.domain.RAMKit
import com.mohaberabi.devicekit.domain.constants.BYTE_NUMBER

class AndroidRAMKit(
    override val availableRam: Long,
    override val totalRam: Long
) : RAMKit {
    override val ramInfo: String = "Available:${availableRam} MB\\nTotal:${totalRam} MB\""
}

internal fun Context.getTotalRam() =
    with(requireNotNull(getSystemService<ActivityManager>())) { getTotalRam() }

internal fun Context.availableRam() =
    with(requireNotNull(getSystemService<ActivityManager>())) { availableRam() }

internal fun ActivityManager.getTotalRam(): Long {
    val memInfo = ActivityManager.MemoryInfo()
    getMemoryInfo(memInfo)
    return memInfo.totalMem / (BYTE_NUMBER * BYTE_NUMBER)
}

internal fun ActivityManager.availableRam(): Long {
    val memInfo = ActivityManager.MemoryInfo()
    getMemoryInfo(memInfo)
    return memInfo.availMem / (BYTE_NUMBER * BYTE_NUMBER)
}

