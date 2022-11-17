package org.nathit.currencybtc.data.local.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.nathit.currencybtc.data.local.sharedpreeeeferences.SecurePreferences

val localModule = module {
    single { SecurePreferences(androidContext()) }
}