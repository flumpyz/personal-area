package com.example.personalarea.common

import RetrofitServices
import com.example.personalarea.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://61f5894b62f1e300173c41ba.mockapi.io/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}