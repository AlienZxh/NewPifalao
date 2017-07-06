package com.j1j2.data.webapi.body

/**
 * Created by albertz on 17-7-4.
 */
data class LoginBody(val loginAccount: String, val passWord: String,
                     var deviceToken: String = "", val terminalType: Int = 1,
                     var userType: Int = 5)