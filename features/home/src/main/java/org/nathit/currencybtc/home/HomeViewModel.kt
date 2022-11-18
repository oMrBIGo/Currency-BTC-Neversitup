package org.nathit.currencybtc.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.nathit.currencybtc.common.ui.base.BaseViewModel
import org.nathit.currencybtc.domain.model.CurrentPrice
import org.nathit.currencybtc.domain.model.NetworkResponse
import org.nathit.currencybtc.domain.usecase.HomeUseCase
import org.nathit.currencybtc.domain.usecase.SecurePreferencesUseCase

class HomeViewModel(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    var currentPriceResult = MutableLiveData<CurrentPrice>()

    fun getCurrentPriceList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getCurrentPrice()) {
                is NetworkResponse.Success -> {
                    currentPriceResult.value = result.body
                }
                is NetworkResponse.ApiError -> {
                    handlerError(result.body)
                }
                is NetworkResponse.NetworkError -> {
                    createOneButtonDialogEvent(messageRes = R.string.Error_Network_title)
                }
                is NetworkResponse.UnknownError -> {
                    createAlertDialogEvent()
                }
                else -> {}
            }
            progressDialogEvent.value = false
        }
    }

}