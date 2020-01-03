package com.gang.lib_base.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import java.lang.Exception

class AppUtils {
    /**
     * 获取版本名称:versionName
     */
    fun getViersionName(context: Context): String {
        return try {
            context.packageManager.getPackageInfo(
                context.packageName,
                PackageManager.GET_ACTIVITIES
            ).versionName
        } catch (ext: Exception) {
            ""
        } catch (ext: NoSuchMethodError) {
            ""
        }
    }

    /**
     * 获取版本号:versionCode
     */
    fun getVersionCode(context: Context): Long {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_ACTIVITIES
                ).longVersionCode
            } else {
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_ACTIVITIES
                ).versionCode.toLong()
            }
        } catch (ext: Exception) {
            0
        } catch (ext: NoSuchMethodError) {
            0
        }
    }
}