package com.yz3ro.coinprices.data.retrofit

import com.yz3ro.coinprices.data.entity.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApiServices {
    @GET("economy/coin/exchange-rate")
    suspend fun getCoins(
        @Query("apiKey") apiKey: String
    ) : ExchangeRateResponse
}