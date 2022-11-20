package org.nathit.currencybtc.domain.di

import org.koin.dsl.module
import org.nathit.currencybtc.domain.usecase.HomeUseCase

val domainModule = module {
    single { HomeUseCase(get()) }
}