package com.j1j2.common.utils

import android.content.Context
import android.content.pm.ApplicationInfo


/**
 * Created by albertz on 17-6-27.
 */
object DebugUtils {

    private var isDebug: Boolean? = null

    fun isDebug(): Boolean = isDebug ?: false


    fun syncIsDebug(context: Context) {
        if (isDebug == null) isDebug = context.applicationInfo != null && (context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
    }
}