package org.nathit.currencybtc

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import org.nathit.currencybtc.domain.utils.LocaleManager
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ContextWrapper(LocaleManager.setLocale(newBase)))
    }

    override fun onResume() {
        super.onResume()
        Locale.setDefault(resources.configuration.locale)
    }
}