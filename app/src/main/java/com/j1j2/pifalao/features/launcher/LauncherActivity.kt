package com.j1j2.pifalao.features.launcher

import android.content.Intent
import com.j1j2.common.base.BaseMviActivity
import com.j1j2.data.interactor.LogStateInteractor
import com.j1j2.data.webapi.body.LoginBody
import com.j1j2.pifalao.R
import io.reactivex.Observable
import javax.inject.Inject

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LauncherActivity : BaseMviActivity<LauncherView, LauncherPresenter>(), LauncherView {

    @Inject
    internal lateinit var lacuncher: LauncherPresenter
    @Inject
    internal lateinit var logStateInteractor: LogStateInteractor

    override fun layoutId(): Int = R.layout.activity_launcher

    override fun createPresenter(): LauncherPresenter = lacuncher

    override fun loadLogState(): Observable<Boolean> = logStateInteractor.login(LoginBody("", "")).toObservable()

    override fun render(state: LauncherViewState) {
        when (state) {
            is LauncherViewState.LoginStateView -> {
            }
            is LauncherViewState.LogoutStateView -> {
            }
        }
    }
}
