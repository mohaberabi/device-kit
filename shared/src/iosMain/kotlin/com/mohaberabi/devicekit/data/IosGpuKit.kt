package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.GPUKit
import platform.Metal.MTLCreateSystemDefaultDevice
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.UIKit.UIUserInterfaceIdiomTV


internal class IosGpuKit : GPUKit {
    override val gpuInfo: String = MTLCreateSystemDefaultDevice()?.name ?: "Unknown"
    override val screenSize: String = getScreenSize()
    override val screenDensity: Float = UIScreen.mainScreen.scale.toFloat()
    override val refreshRate: Float = UIScreen.mainScreen.maximumFramesPerSecond.toFloat()
    override val resolution: String = ""

}

internal fun getScreenSize(): String {
    val isIpad = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomPad
    val isTv = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomTV
    val isIphone = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomPhone
    return when {
        isIpad -> "I-Pad"
        isTv -> "Apple TV"
        isIphone -> "Iphone"
        else -> "Unknown"
    }
}

