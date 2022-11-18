package org.nathit.currencybtc.domain.repository

import org.nathit.currencybtc.domain.model.CommonError
import org.nathit.currencybtc.domain.model.CurrentPrice
import org.nathit.currencybtc.domain.model.NetworkResponse

interface HomeRepository {

    suspend fun getCurrentPrice(): NetworkResponse<CurrentPrice, CommonError>?
}