package com.mohaberabi.devicekit.data.helper

import android.content.Context


internal fun Context.deviceResolution(): String {
    val metrics = resources.displayMetrics
    val height = metrics.heightPixels
    val width = metrics.widthPixels
    if (height > width) {
        return "$height:$width"
    }
    return "$width:$height"
}