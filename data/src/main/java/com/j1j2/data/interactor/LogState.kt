package com.j1j2.data.interactor

import com.j1j2.data.model.LoginResponse

/**
 * Created by albertz on 17-7-4.
 */
class LogState private constructor() {

    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LogState()
        }
    }

    var isLogin: Boolean? = null
    var userInfo: LoginResponse? = null


    fun isLogin(): Boolean = isLogin ?: false

    fun login(loginResponse: LoginResponse) {
        isLogin = true
        userInfo = loginResponse
    }

    fun loginout() {
        isLogin = false
        userInfo = null
    }


}