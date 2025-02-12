package com.mohaberabi.devicekit.data.helper

import android.app.ActivityManager
import android.content.Context
import androidx.core.content.getSystemService
import com.mohaberabi.devicekit.domain.constants.BYTE_NUMBER

fun Context.getTotalRam() =
    with(requireNotNull(getSystemService<ActivityManager>())) { getTotalRam() }

fun Context.availableRam() =
    with(requireNotNull(getSystemService<ActivityManager>())) { availableRam() }

fun ActivityManager.getTotalRam(): Long {
    val memInfo = ActivityManager.MemoryInfo()
    getMemoryInfo(memInfo)
    return memInfo.totalMem / (BYTE_NUMBER * BYTE_NUMBER)
}

fun ActivityManager.availableRam(): Long {
    val memInfo = ActivityManager.MemoryInfo()
    getMemoryInfo(memInfo)
    return memInfo.availMem / (BYTE_NUMBER * BYTE_NUMBER)
}

