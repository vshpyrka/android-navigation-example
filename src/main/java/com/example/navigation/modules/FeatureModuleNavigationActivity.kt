package com.example.navigation.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.databinding.ActivityFeatureModuleNavigationBinding

class FeatureModuleNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFeatureModuleNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = binding.container.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()

        binding.bottomNav.setupWithNavController(navController)
    }
}
