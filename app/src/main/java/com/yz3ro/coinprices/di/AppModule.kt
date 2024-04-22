package com.yz3ro.coinprices.di

import com.yz3ro.coinprices.data.datasource.CoinPricesDataSource
import com.yz3ro.coinprices.data.repo.CoinPricesRepository
import com.yz3ro.coinprices.data.retrofit.CoinApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideCoinApiService(): CoinApiServices {
        return Retrofit.Builder()
            .baseUrl("https://www.nosyapi.com/apiv2/service/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApiServices::class.java)
    }
    @Singleton
    @Provides
    fun provideCoinPricesDataSource(apiService: CoinApiServices): CoinPricesDataSource {
        return CoinPricesDataSource(apiService)
    }

    @Singleton
    @Provides
    fun provideCoinPricesRepository(dataSource: CoinPricesDataSource): CoinPricesRepository {
        return CoinPricesRepository(dataSource)
    }

}