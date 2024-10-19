package com.example.navigation.ui.actionbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavigationUiActionBarBinding

class NavigationUiActionBarActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationUiActionBarBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.content)

        val navHostFragment = binding.content.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.content)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
