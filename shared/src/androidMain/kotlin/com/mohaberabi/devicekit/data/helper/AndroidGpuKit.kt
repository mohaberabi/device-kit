package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.content.res.Configuration
import android.opengl.GLES20
import android.os.Build
import com.mohaberabi.devicekit.domain.GPUKit
import javax.microedition.khronos.opengles.GL10

internal class AndroidGpuKit(
    private val density: Float,
    private val rateOfRefresh: Float,
    override val resolution: String,
    override val screenSize: String
) : GPUKit {
    override val gpuInfo: String = GLES20.glGetString(GL10.GL_RENDERER)
    override val screenDensity: Float = density
    override val refreshRate: Float = rateOfRefresh

}

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

internal fun Context.deviceResolution(): String {
    val metrics = resources.displayMetrics
    val height = metrics.heightPixels
    val width = metrics.widthPixels
    if (height > width) {
        return "$height:$width"
    }
    return "$width:$height"
}