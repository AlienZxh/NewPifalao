package com.j1j2.pifalao.features.launcher

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

/**
 * Created by albertz on 17-6-29.
 */
interface LauncherView : MvpView {


    fun loadLogState(): Observable<Boolean>

    fun render(state: LauncherViewState)
}