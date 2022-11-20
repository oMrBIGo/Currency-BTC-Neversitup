package org.nathit.currencybtc.convert.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.nathit.currencybtc.convert.ConvertViewModel

val featureConvert = module {
    viewModel { ConvertViewModel() }
}