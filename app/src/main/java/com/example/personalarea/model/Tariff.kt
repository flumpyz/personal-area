package com.example.personalarea.model

data class Tariff(
    var title: String? = null,
    var description: String? = null,
    var speed: Int? = 100,
    var cost: Double? = 100.00,
    var id: Int? = null
)
