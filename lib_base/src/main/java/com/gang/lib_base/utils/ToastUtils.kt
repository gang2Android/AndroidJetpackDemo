package com.gang.lib_base.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(content: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, content, duration).apply {
        show()
    }
}