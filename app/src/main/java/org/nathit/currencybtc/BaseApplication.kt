package org.nathit.currencybtc

import android.app.Application
import android.content.res.Configuration
import com.chuckerteam.chucker.api.ChuckerInterceptor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.nathit.currencybtc.di.createAppModule
import org.nathit.currencybtc.domain.utils.LocaleManager

@FlowPreview
@ExperimentalCoroutinesApi
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    open fun configureDi() =
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                createAppModule(
                    interceptor = ChuckerInterceptor.Builder(
                        applicationContext
                    ).build()
                )
            )
        }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
}