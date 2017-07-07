package com.j1j2.pifalao.features.launcher

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.j1j2.common.base.BaseMviActivity
import com.j1j2.data.interactor.LogStateInteractor
import com.j1j2.data.webapi.body.LoginBody
import io.reactivex.Observable
import org.jetbrains.anko.AnkoComponent
import javax.inject.Inject

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LauncherActivity : BaseMviActivity<LauncherUI, LauncherView, LauncherPresenter>(), LauncherView {

    @Inject
    internal lateinit var lacuncher: LauncherPresenter
    @Inject
    internal lateinit var logStateInteractor: LogStateInteractor

    override fun createUI(): LauncherUI = LauncherUI()

    override fun createPresenter(): LauncherPresenter = lacuncher

    override fun loadLogState(): Observable<Boolean> = logStateInteractor.login(LoginBody("15200348636", "123456"))

    override fun render(state: LauncherViewState) {

        when (state) {
            is LauncherViewState.LoginStateView -> {
                Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show()
            }
            is LauncherViewState.LogoutStateView -> {
                Toast.makeText(this, "登陆失败", Toast.LENGTH_LONG).show()
            }
        }
    }
}
