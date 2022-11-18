package org.nathit.currencybtc.domain.usecase

import org.nathit.currencybtc.domain.repository.HomeRepository

class HomeUseCase(private val repo: HomeRepository) {

    suspend fun getCurrentPrice() = repo.getCurrentPrice()

}