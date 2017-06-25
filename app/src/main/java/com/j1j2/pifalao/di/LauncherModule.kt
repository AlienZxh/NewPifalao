package com.j1j2.pifalao.di


import android.app.LauncherActivity
import dagger.Binds
import dagger.Module


/**
 * Created by zxh19 on 2017/6/25.
 */
@Module
abstract class LauncherModule {
    @Binds
    abstract fun provideLauncherView(launcherActivity: LauncherActivity): LauncherActivity
}