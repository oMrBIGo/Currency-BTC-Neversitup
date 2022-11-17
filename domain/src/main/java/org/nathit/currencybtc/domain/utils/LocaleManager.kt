package org.nathit.currencybtc.domain.utils

import android.content.Context
import java.util.*

class LocaleManager {
    companion object {
        fun setLocale(context: Context): Context? {
            return updateResources(context)
        }

        private fun updateResources(context: Context): Context? {
            val configuration = context.resources.configuration
            return context.createConfigurationContext(configuration)
        }
    }
}