package org.nathit.currencybtc.data.remote.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun createHttpClient(chuckerInterceptor: Interceptor) = module {
    single(named("httpLoggingInterceptor")) {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>(named("httpLoggingInterceptor")))
            .addNetworkInterceptor(chuckerInterceptor)
            .build()
    }
}
