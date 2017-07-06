package com.j1j2.pifalao.di

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.j1j2.pifalao.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by zxh19 on 2017/6/25.
 */
@Module(subcomponents = arrayOf(LauncherComponent::class))
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: Application): Context


    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
            .serializeNulls()
            .create()


    @Provides
    @Singleton
    fun provideOkHttpClient(gson: Gson, context: Context): OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
//                .authenticator(BaseAuthenticator(context, iChangeLogState, iLoginRequired, toastor))
//                .cookieJar(BaseLocalCookieJar(gson, tokenRepository))
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

}