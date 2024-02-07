package com.example.navigation.interaction.dynamicnavhost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.R

class DynamicNavHostActivity : AppCompatActivity(R.layout.activity_dynamic_nav_host) {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dynamic NavHost doesn't restore state when config change or app killed
        val navHost =
            NavHostFragment.create(R.navigation.activity_navigation_dynamic_nav_host_nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commitNow()

        navController = navHost.navController
        appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
