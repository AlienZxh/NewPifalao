package com.j1j2.data.interactor

import com.j1j2.data.webapi.LoginAPI
import com.j1j2.data.webapi.body.LoginBody
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by albertz on 17-7-5.
 */
class LogStateInteractor @Inject constructor(val loginAPI: LoginAPI, val logState: LogState) {


    fun login(loginBody: LoginBody): Single<Boolean> = loginAPI.login(loginBody)
            .doOnSuccess { webReturn -> logState.login(webReturn.detail) }
            .doOnError { logState.loginout() }
            .map { webReturn -> webReturn.value }

}