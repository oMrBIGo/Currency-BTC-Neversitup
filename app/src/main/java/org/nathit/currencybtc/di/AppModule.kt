package org.nathit.currencybtc.di

import okhttp3.Interceptor
import org.nathit.currencybtc.BuildConfig
import org.nathit.currencybtc.convert.di.featureConvert
import org.nathit.currencybtc.data.model.di.modelModule
import org.nathit.currencybtc.data.remote.di.createHttpClient
import org.nathit.currencybtc.data.remote.di.createRemoteModule
import org.nathit.currencybtc.data.repository.di.repositoryModule
import org.nathit.currencybtc.domain.di.domainModule
import org.nathit.currencybtc.home.di.featureHome

fun createAppModule(interceptor: Interceptor) = listOf(
    createHttpClient(interceptor),
    createRemoteModule(BuildConfig.BASE_API_URL),
    repositoryModule,
    domainModule,
    modelModule,
    featureHome,
    featureConvert
)