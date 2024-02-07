package com.example.navigation.interaction.modifygraph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.R
import com.example.navigation.databinding.ActivityNavigationModifyNavGraphBinding

class NavigationModifyNavGraphActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationModifyNavGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = binding.container.getFragment<NavHostFragment>()
        val navController = navHost.findNavController()

        val navGraph =
            navController.navInflater.inflate(R.navigation.activity_navigation_modify_runtime_nav_graph)

        navGraph.setStartDestination(R.id.settings)

        // Always will navigate back to start destination

        navController.graph = navGraph

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.modify_nav_graph_info,
                R.id.modify_nav_graph_settings
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )

        binding.bottomNav.setupWithNavController(navController)

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
