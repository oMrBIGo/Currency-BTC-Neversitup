package org.nathit.currencybtc.data.repository.di

import org.koin.dsl.module
import org.nathit.currencybtc.data.repository.HomeRepositoryImpl
import org.nathit.currencybtc.domain.repository.HomeRepository

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}