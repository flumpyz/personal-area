package com.example.personalarea.model

data class Balance(
    var accNum: Int?,
    var balance: Double? = 0.00,
    var nextPay: Double? = 0.00,
    var id: Int?
)
