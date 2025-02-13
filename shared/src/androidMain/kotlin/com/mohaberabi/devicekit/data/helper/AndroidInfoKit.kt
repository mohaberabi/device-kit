package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.icu.util.Calendar
import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import android.os.Build.VERSION
import com.mohaberabi.devicekit.domain.InfoKit

internal class AndroidInfoKit(
    override val appSize: Double
) : InfoKit {
    override val osName: String = "Android"
    override val osVersion: String = VERSION.RELEASE
    private val releaseText =
        osVersion.replace("(\\d+[.]\\d+)(.*)", "$1").toDoubleOrNull() ?: 0.0
    override val osVersionName: String = releaseText.mapVersionCodeToName()
    override val deviceTimeZone: String = Calendar.getInstance().timeZone.displayName
    override val model: String = MODEL
    override val uuid: String = ""
    override val deviceName: String = ""
    override val manufacturer: String = MANUFACTURER
}

internal fun Double.mapVersionCodeToName(): String {
    val release = this
    val name = when {
        release >= 4.1 && release < 4.4 -> "Jelly Bean"
        release < 5 -> "Kit Kat"
        release < 6 -> "Lollipop"
        release < 7 -> "Marshmallow"
        release < 8 -> "Nougat"
        release < 9 -> "Oreo"
        release < 10 -> "Pie"
        release >= 10 -> "Android ${release.toInt()}"
        else -> "Unsupported"
    }
    return "$name v $release , API LEVEL: ${VERSION.SDK_INT}"
}
