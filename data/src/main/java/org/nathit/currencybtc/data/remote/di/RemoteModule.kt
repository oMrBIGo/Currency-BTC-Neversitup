package org.nathit.currencybtc.data.remote.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.nathit.currencybtc.data.remote.home.HomeService
import org.nathit.currencybtc.data.utils.NetworkResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseApiUrl: String) = module {
    single(named("retrofit")) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseApiUrl)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>(named("retrofit")).create(HomeService::class.java) }

}