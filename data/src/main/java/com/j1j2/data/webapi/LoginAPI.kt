package com.j1j2.data.webapi

import com.j1j2.data.model.LoginResponse
import com.j1j2.data.model.WebReturn
import com.j1j2.data.webapi.body.LoginBody
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST



/**
 * Created by albertz on 17-7-4.
 */
interface LoginAPI{
    @POST("UserLogin/Login")
    fun login(@Body loginBody: LoginBody): Single<WebReturn<LoginResponse>>
}