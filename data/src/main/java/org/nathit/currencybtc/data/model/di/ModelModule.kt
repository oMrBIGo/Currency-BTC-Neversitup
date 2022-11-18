package org.nathit.currencybtc.data.model.di

import org.koin.dsl.module
import org.nathit.currencybtc.data.model.mapper.CurrentPriceMapper

val modelModule = module {
    single { CurrentPriceMapper() }
}