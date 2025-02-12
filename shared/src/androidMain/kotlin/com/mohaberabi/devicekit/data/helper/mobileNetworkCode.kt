package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.telephony.TelephonyManager
import androidx.core.content.getSystemService

internal fun Context.mobileNetworkCode(): String? =
    with(requireNotNull(getSystemService<TelephonyManager>())) { mobileNetworkCode() }

internal fun Context.mobileCountryCode(): String? =
    with(requireNotNull(getSystemService<TelephonyManager>())) { mobileCountryCode() }

internal fun TelephonyManager.mobileCountryCode(): String? = networkOperator.subStringOrNull(0, 3)
internal fun TelephonyManager.mobileNetworkCode(): String? {
    val mnc = networkOperator.subStringOrNull(3)?.toIntOrNull() ?: return null
    if ("$mnc".count() < 2) return "0$mnc"
    return "$mnc"

}

fun String.subStringOrNull(start: Int, end: Int? = null): String? {
    if (start >= length) {
        return null
    }

    if (end != null) {
        if (end >= length) {
            return null
        }
        return substring(start, end)
    }
    return substring(start)
}