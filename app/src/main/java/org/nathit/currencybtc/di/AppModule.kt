package org.nathit.currencybtc.di

import okhttp3.Interceptor
import org.nathit.currencybtc.BuildConfig
import org.nathit.currencybtc.data.local.di.localModule
import org.nathit.currencybtc.data.model.di.modelModule
import org.nathit.currencybtc.data.remote.di.createHttpClient
import org.nathit.currencybtc.data.remote.di.createRemoteModule
import org.nathit.currencybtc.data.repository.di.repositoryModule
import org.nathit.currencybtc.domain.di.createBuildConfigModule
import org.nathit.currencybtc.domain.di.domainModule
import org.nathit.currencybtc.home.di.featureHome

fun createAppModule(interceptor: Interceptor) = listOf(
    createHttpClient(interceptor),
    createRemoteModule(BuildConfig.BASE_API_URL),
    createBuildConfigModule(
        BuildConfig.VERSION_NAME,
        BuildConfig.BUILD_TYPE,
        BuildConfig.VERSION_CODE
    ),
    repositoryModule,
    domainModule,
    modelModule,
    localModule,
    featureHome
)