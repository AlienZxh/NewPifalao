package com.j1j2.pifalao.features.launcher

import com.j1j2.common.base.BaseMviActivity
import com.j1j2.pifalao.R
import javax.inject.Inject

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LauncherActivity : BaseMviActivity<LauncherView, LauncherPresenter>(), LauncherView {

    @Inject
    internal lateinit var lacuncher: LauncherPresenter

    override fun layoutId(): Int = R.layout.activity_launcher

    override fun createPresenter(): LauncherPresenter = lacuncher
}
