package org.nathit.currencybtc.data.repository.di

import org.koin.dsl.module
import org.nathit.currencybtc.data.repository.SecurePreferenceRepositoryImpl
import org.nathit.currencybtc.domain.repository.SecurePreferenceRepository

val repositoryModule = module {
    single<SecurePreferenceRepository> { SecurePreferenceRepositoryImpl(get()) }
}