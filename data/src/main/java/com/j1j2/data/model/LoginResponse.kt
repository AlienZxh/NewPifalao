package com.j1j2.data.model

import java.math.BigDecimal

/**
 * Created by albertz on 17-7-4.
 */
data class LoginResponse(val userID: Int, val loginAccount: String, val mobile: String, val portrait: String, val point: Int,
                         val userName: String, val registerTimeStr: String, val cost: BigDecimal, val userSaveAmount: BigDecimal,
                         val balance: BigDecimal, val mobileVerfied: Boolean)