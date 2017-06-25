package com.j1j2.pifalao.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


/**
 * Created by zxh19 on 2017/6/25.
 */
@Module(subcomponents = arrayOf(LauncherComponent::class))
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: Application): Context

}