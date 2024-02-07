package com.example.navigation.ui.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.R
import com.example.navigation.databinding.ActivityNavigationUiBottomNavBinding

class NavigationUiBottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationUiBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = binding.container.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()
        binding.bottomNav.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigationUiBottomNavInfoFragment,
                R.id.navigationUiBottomNavSettingsFragment
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
