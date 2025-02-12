package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.content.res.Configuration


internal fun Context.getScreenSize(): String {
    val screenOrientation = resources.configuration.screenLayout
    val isMobile = screenOrientation and
            Configuration.SCREENLAYOUT_SIZE_MASK < Configuration.SCREENLAYOUT_SIZE_LARGE
    val isTablet = screenOrientation and
            Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    val isLargeTablet = screenOrientation and
            Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE
    val isXLTablet = screenOrientation and
            Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_XLARGE
    return when {
        isMobile -> "mobile"
        isLargeTablet -> "large"
        isXLTablet -> "xLarge"
        isTablet -> "tablet"
        else -> "unknown"
    }

}