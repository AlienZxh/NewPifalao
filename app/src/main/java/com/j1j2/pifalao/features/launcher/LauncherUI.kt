package com.j1j2.pifalao.features.launcher

import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.j1j2.pifalao.R
import org.jetbrains.anko.*

/**
 * Created by albertz on 17-7-7.
 */
class LauncherUI : AnkoComponent<Activity> {
    lateinit var layout: LinearLayout
    lateinit var testBtn: Button

    override fun createView(ui: AnkoContext<Activity>): View {
        layout = with(ui) {
            verticalLayout {
                backgroundResource = R.color.colorPrimary

                testBtn = button("测试")
            }
        }
        return layout;
    }

}