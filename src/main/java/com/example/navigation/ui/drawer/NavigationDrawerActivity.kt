package com.example.navigation.ui.drawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.R
import com.example.navigation.databinding.ActivityNavigationDrawerBinding

class NavigationDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = binding.container.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()

        // Top level items in drawer menu
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home,
                R.id.info,
                R.id.settings
            ),
            binding.drawerLayout
        )

        // Without top level items. Start destination item will always be first, others will have back arrow
        // val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }
}
