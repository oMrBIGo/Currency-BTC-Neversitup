package org.nathit.currencybtc.home

import NavigationCommand
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.nathit.currencybtc.common.ui.base.BaseViewModel
import org.nathit.currencybtc.domain.model.CurrentPrice
import org.nathit.currencybtc.domain.model.NetworkResponse
import org.nathit.currencybtc.domain.usecase.HomeUseCase
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow


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

    fun prettyCount(number: Double): String? {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val value = floor(log10(number)).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#0.0").format(number / 10.0.pow((base * 3).toDouble())) + suffix[base]
        } else {
            DecimalFormat("#,##0").format(number)
        }
    }

    fun fibonacci(n: Int): String {
        val result = LongArray(n) // long ใช้เพื่อหลีกเลี่ยงจากการ overflow
        result[1] = 1
        // สร้างลำดับ fibonacci มาเก็บไว้ใน Array
        for (i in 2 until n) {
            result[i] = result[i - 1] + result[i - 2]
        }
        return result.contentToString() // แปลง Array เป็น String และส่งกลับ
    }

    fun primes(n: Int): MutableList<Int> {
        val li: MutableList<Int> = mutableListOf()
        for (num in 2..n + 1) {
            for (i in 2..num) {
                if (num % i == 0) {
                    if (num == i) li.add(num) else break
                }
            }
        }
        return li
    }

    val displayConvert: () -> Unit = {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavConvert()
            )
        )
    }
}
