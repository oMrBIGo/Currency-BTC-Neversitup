package org.nathit.currencybtc.data.repository

import org.nathit.currencybtc.data.model.mapper.CurrentPriceMapper
import org.nathit.currencybtc.data.remote.home.HomeService
import org.nathit.currencybtc.domain.model.CommonError
import org.nathit.currencybtc.domain.model.CurrentPrice
import org.nathit.currencybtc.domain.model.NetworkResponse
import org.nathit.currencybtc.domain.model.mapOnSuccess
import org.nathit.currencybtc.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val currentPriceMapper: CurrentPriceMapper,
    private val homeService: HomeService
) : HomeRepository {

    override suspend fun getCurrentPrice(): NetworkResponse<CurrentPrice, CommonError>? {
        return homeService.getCurrentPrice(
        ).mapOnSuccess(currentPriceMapper::map)
    }
}