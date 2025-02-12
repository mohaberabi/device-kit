package device_info

import android.os.Build.VERSION


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
