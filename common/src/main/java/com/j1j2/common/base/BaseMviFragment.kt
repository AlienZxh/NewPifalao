package com.j1j2.common.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import com.hannesdorfmann.mosby3.mvi.MviPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by albertz on 17-6-28.
 */
abstract class BaseMviFragment<V : MvpView, P : MviPresenter<V, *>> : MviFragment<V, P>(), HasSupportFragmentInjector {
    @Inject
    internal lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    @LayoutRes
    protected abstract fun layoutId(): Int

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(layoutId(), container, false)


    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.childFragmentInjector

}