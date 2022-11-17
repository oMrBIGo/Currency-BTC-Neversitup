package org.nathit.currencybtc.data.remote.di

import com.facebook.stetho.okhttp3.StethoInterceptor
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
    single(named("stethoInterceptor")) {
        StethoInterceptor()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>(named("httpLoggingInterceptor")))
            .addNetworkInterceptor(get<StethoInterceptor>(named("stethoInterceptor")))
            .addNetworkInterceptor(chuckerInterceptor)
            .build()
    }
}
