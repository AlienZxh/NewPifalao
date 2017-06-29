package com.j1j2.common.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.gyf.barlibrary.ImmersionBar
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.hannesdorfmann.mosby3.mvi.MviPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.j1j2.common.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import dmax.dialog.SpotsDialog
import javax.inject.Inject


/**
 * Created by albertz on 17-6-28.
 */
abstract class BaseMviActivity<V : MvpView, P : MviPresenter<V, *>> : MviActivity<V, P>(), HasFragmentInjector, HasSupportFragmentInjector {
    protected val TAG = this.javaClass.simpleName

    @Inject
    internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    private val progressDialog: SpotsDialog by lazy { SpotsDialog(this) }

    @LayoutRes
    protected abstract fun layoutId(): Int

    protected fun immersionBar(): ImmersionBar = ImmersionBar.with(this).statusBarColor(R.color.colorPrimaryDark).fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        immersionBar().init()
        setContentView(layoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy()
    }

    fun showLoadingDialog(message: CharSequence, cancelable: Boolean = false) {
        progressDialog.setMessage(message)
        progressDialog.setCancelable(cancelable)
        if (!progressDialog.isShowing()) progressDialog.show()
    }

    fun dismissLoadingDialog() {
        if (progressDialog.isShowing()) progressDialog.dismiss()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.supportFragmentInjector

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment> = this.frameworkFragmentInjector
}