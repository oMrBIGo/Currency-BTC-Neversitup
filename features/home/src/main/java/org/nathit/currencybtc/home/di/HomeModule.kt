package org.nathit.currencybtc.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.nathit.currencybtc.home.HomeViewModel

val featureHome = module {
    viewModel { HomeViewModel() }
}