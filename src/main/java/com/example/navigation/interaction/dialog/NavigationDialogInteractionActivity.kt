package com.example.navigation.interaction.dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.databinding.ActivityNavigationDialogInteractionBinding

class NavigationDialogInteractionActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationDialogInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = binding.container.getFragment<NavHostFragment>()
        navController = navHost.navController
        appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
