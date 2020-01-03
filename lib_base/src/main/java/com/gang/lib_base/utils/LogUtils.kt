package com.gang.lib_base.utils

import android.util.Log

object LogUtils {
    private var isDebug = true

    fun setDebug(debug: Boolean) {
        isDebug = debug
    }

    fun log(tag: String, txt: String) {
        if (isDebug)
            Log.e(tag, txt)
    }
}