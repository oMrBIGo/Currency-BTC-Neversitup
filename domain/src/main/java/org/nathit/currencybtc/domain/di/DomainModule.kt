package org.nathit.currencybtc.domain.di

import org.koin.dsl.module
import org.nathit.currencybtc.domain.usecase.HomeUseCase
import org.nathit.currencybtc.domain.usecase.SecurePreferencesUseCase

val domainModule = module {
    single { SecurePreferencesUseCase(get()) }
    single { HomeUseCase(get()) }
}