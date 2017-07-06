package com.j1j2.pifalao.features.launcher

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by albertz on 17-6-29.
 */
class LauncherPresenter @Inject constructor() : MviBasePresenter<LauncherView, LauncherViewState>() {


    override fun bindIntents() {
        val logstate: Observable<LauncherViewState> = intent(LauncherView::loadLogState)
                .map { isLogin -> if (isLogin) LauncherViewState.LoginStateView() else LauncherViewState.LogoutStateView() }
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(logstate, LauncherView::render)
    }
}