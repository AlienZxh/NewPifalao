package com.j1j2.pifalao.di

import com.j1j2.data.interactor.LogState
import com.j1j2.data.interactor.LogStateInteractor
import com.j1j2.data.webapi.LoginAPI
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by albertz on 17-7-5.
 */
@Module(subcomponents = arrayOf(LauncherComponent::class))
abstract class InteractorModule {

    @Provides
    @Singleton
    fun provideLoginAPI(retrofit: Retrofit): LoginAPI = retrofit.create(LoginAPI::class.java)

    @Provides
    @Singleton
    fun provideLogState(): LogState = LogState.instance

    @Binds
    @Singleton
    abstract fun provideLogStateInteractor(logStateInteractor: LogStateInteractor): LogStateInteractor


}