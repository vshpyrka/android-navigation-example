package com.example.navigation.ui.destination

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavigationUiDestinationListenerBinding

class NavigationUiDestinationListenerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationUiDestinationListenerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationUiDestinationListenerBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment = binding.container.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener(destinationChangeListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private val destinationChangeListener =
        NavController.OnDestinationChangedListener { _, destination, args ->
            binding.fab.isVisible =
                destination.id != R.id.navigationUiDestinationListenerFragmentTwo
        }

    override fun onDestroy() {
        findNavController(R.id.container).removeOnDestinationChangedListener(
            destinationChangeListener
        )
        super.onDestroy()
    }
}
