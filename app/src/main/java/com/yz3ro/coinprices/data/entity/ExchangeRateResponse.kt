package com.yz3ro.coinprices.data.entity

data class ExchangeRateResponse(
    val creditUsed: Int,
    val `data`: List<Exchange>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)