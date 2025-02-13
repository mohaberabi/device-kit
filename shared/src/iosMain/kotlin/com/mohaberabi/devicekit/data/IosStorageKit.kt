package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.StorageKit
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSFileManager
import platform.Foundation.NSFileSystemFreeSize
import platform.Foundation.NSFileSystemSize
import platform.Foundation.NSHomeDirectory

internal class IosStorageKit : StorageKit {
    override val totalInternalStorageSize: Long = totalInternalStorage()
    override val availableInternalStorageSize: Long = availableInternalStorage()
    override val availableExternalStorageSize: Long? = null
    override val externalStorageAvailable: Boolean = false
    override val storageInfo: String =
        "TOTAL : $totalInternalStorageSize , AVAILABLE :${availableInternalStorageSize}"
}

@OptIn(ExperimentalForeignApi::class)
internal fun totalInternalStorage(): Long {
    val fileManager = NSFileManager.defaultManager
    return fileManager.attributesOfFileSystemForPath(NSHomeDirectory(), null)
        ?.get(NSFileSystemSize) as? Long ?: 0L
}

@OptIn(ExperimentalForeignApi::class)
internal fun availableInternalStorage(): Long {
    val fileManager = NSFileManager.defaultManager
    return fileManager.attributesOfFileSystemForPath(NSHomeDirectory(), null)
        ?.get(NSFileSystemFreeSize) as? Long ?: 0L
}
