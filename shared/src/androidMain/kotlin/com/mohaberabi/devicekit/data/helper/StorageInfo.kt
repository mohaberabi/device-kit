package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.os.Environment
import android.os.StatFs
import com.mohaberabi.devicekit.domain.constants.BYTE_NUMBER


internal val isExternalStorageAvailable =
    Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

internal fun availableInternalStorageSize(): Long {
    val path = Environment.getDataDirectory()
    val state = StatFs(path.path)
    val blockSize = state.blockSizeLong
    val availableBlocks = state.availableBlocksLong
    return (availableBlocks * blockSize) / (BYTE_NUMBER * BYTE_NUMBER)
}


internal fun totalInternalStorageSize(): Long {
    val path = Environment.getDataDirectory()
    val stat = StatFs(path.path)
    val blockSize = stat.blockSizeLong
    val totalBlocks = stat.blockCountLong
    return (totalBlocks * blockSize) / (BYTE_NUMBER * BYTE_NUMBER)
}

internal fun Context.totalExternalStorageSize(): Long? {
    if (isExternalStorageAvailable) {
        val file = getExternalFilesDir(null)
        file?.apply {
            val stat = StatFs(path)
            val blockSize = stat.blockSizeLong
            val totalBlocks = stat.blockCountLong
            return totalBlocks * blockSize
        }
    }
    return null
}

internal fun Context.availableExternalStorageSize(): Long? {
    if (isExternalStorageAvailable) {
        val file = getExternalFilesDir(null)
        file?.apply {
            val stat = StatFs(path)
            val blockSize = stat.blockSizeLong
            val availableBlocks = stat.availableBlocksLong
            return availableBlocks * blockSize
        }
    }
    return null
}

