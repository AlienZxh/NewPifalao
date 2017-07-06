package com.j1j2.data.model

/**
 * Created by albertz on 17-7-4.
 */
data class WebReturn<T>(val value: Boolean, val detail: T, val errorMessage: String, val alertMessage: String)