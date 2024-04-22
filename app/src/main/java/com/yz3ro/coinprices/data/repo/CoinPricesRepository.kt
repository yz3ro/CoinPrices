package com.yz3ro.coinprices.data.repo

import com.yz3ro.coinprices.data.datasource.CoinPricesDataSource
import com.yz3ro.coinprices.data.entity.ExchangeRateResponse


class CoinPricesRepository( private val cds : CoinPricesDataSource ) {
    suspend fun getCoins( apiKey: String): ExchangeRateResponse {
        return cds.getCoins(apiKey)
    }
}