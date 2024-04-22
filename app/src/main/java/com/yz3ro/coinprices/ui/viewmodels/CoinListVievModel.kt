package com.yz3ro.coinprices.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yz3ro.coinprices.data.entity.Exchange
import com.yz3ro.coinprices.data.repo.CoinPricesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListVievModel @Inject constructor ( var cps : CoinPricesRepository ) : ViewModel() {
    private val _coins = MutableLiveData<List<Exchange>>()
    val coins : LiveData<List<Exchange>>
        get() = _coins

    fun getCoinsName(apiKey: String) {
        viewModelScope.launch {
            val response = cps.getCoins(apiKey)
            if (response.status == "success") {
                _coins.value = response.data
            } else {

            }
        }
    }
}