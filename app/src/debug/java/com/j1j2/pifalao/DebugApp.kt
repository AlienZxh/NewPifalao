package com.j1j2.pifalao

import android.content.Context
import com.blankj.utilcode.util.EmptyUtils
import com.facebook.stetho.Stetho


/**
 * Created by zxh19 on 2017/6/25.
 */
class DebugApp : App() {
    override fun onCreate() {
        super.onCreate()
        if (!EmptyUtils.isEmpty(processName) && processName.equals(applicationContext.packageName))
            initStetho(this)
    }

    private fun initStetho(context: Context) {
        Stetho.initializeWithDefaults(context)
    }
}