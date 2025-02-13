package com.mohaberabi.devicekit.data.helper

import android.content.Context
import android.telephony.TelephonyManager
import androidx.core.content.getSystemService
import com.mohaberabi.devicekit.domain.CellKit
import com.mohaberabi.devicekit.domain.constants.subStringOrNull

internal class AndroidcellularKit(
    override val mobileNetworkCode: String?,
    override val mobileCountryCode: String?
) : CellKit

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