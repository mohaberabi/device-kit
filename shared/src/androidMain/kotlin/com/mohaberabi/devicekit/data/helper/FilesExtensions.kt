package com.mohaberabi.devicekit.data.helper

import android.content.Context

import java.io.File


fun File.getTotalSizeInBytes(): Long {

    var size = 0L

    val allFiles = listFiles()
    allFiles?.let {
        for (file in it) {
            size += file.length()
            file.getTotalSizeInBytes()
        }
        return size
    }
    return 0
}

internal fun Context.getAppSize(): Double {
    val applicationParentDir = applicationContext.filesDir.parentFile
    val allContentSize = applicationParentDir?.getTotalSizeInBytes()?.toMegaByte() ?: 0.0
    return allContentSize + DEFAULT_APK_SIZE
}

fun Long.toMegaByte(): Double {
    return toDouble() / (1000 * 1000)
}

const val DEFAULT_APK_SIZE = 20
