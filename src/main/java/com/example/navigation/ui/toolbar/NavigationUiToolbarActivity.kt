package com.example.navigation.ui.toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavigationUiToolbarBinding

class NavigationUiToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationUiToolbarBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        // setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment = binding.content.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()
        // Add Back button which navigates to parent activity specified in manifest
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
