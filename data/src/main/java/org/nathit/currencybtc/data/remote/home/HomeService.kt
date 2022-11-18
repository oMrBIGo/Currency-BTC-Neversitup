package org.nathit.currencybtc.data.remote.home

import org.nathit.currencybtc.data.model.CurrentPriceEntity
import org.nathit.currencybtc.domain.model.CommonError
import org.nathit.currencybtc.domain.model.NetworkResponse
import retrofit2.http.GET

interface HomeService {

    @GET("bpi/currentprice.json")
    suspend fun getCurrentPrice(): NetworkResponse<CurrentPriceEntity,CommonError>

}