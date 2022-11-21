package org.nathit.currencybtc

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import org.koin.core.context.startKoin
import org.nathit.currencybtc.di.createAppModule

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    open fun configureDi() =
        startKoin {
            modules(
                createAppModule(
                    interceptor = ChuckerInterceptor.Builder(
                        applicationContext
                    ).build()
                )
            )
        }
}