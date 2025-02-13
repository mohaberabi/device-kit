package com.mohaberabi.devicekit.domain.constants


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