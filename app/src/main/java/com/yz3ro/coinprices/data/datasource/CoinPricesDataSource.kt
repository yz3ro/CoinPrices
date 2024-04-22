package com.yz3ro.coinprices.data.datasource

import com.yz3ro.coinprices.data.entity.ExchangeRateResponse
import com.yz3ro.coinprices.data.retrofit.CoinApiServices

class CoinPricesDataSource (var cas : CoinApiServices) {
    suspend fun getCoins(apiKey: String): ExchangeRateResponse {
        return cas.getCoins(apiKey)
    }
}