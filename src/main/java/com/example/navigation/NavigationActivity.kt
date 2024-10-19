package com.example.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.navigation.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        // findNavController(R.id.nav_host_view)
        // Caused by: java.lang.IllegalStateException: Activity does not have a NavController set on 2131231023
        // Tries to find view by tag - R.id.nav_controller_view_tag
        // Tag is set only after NavHostFragment -> onViewCreated

        // val navHostFragment =
        // supportFragmentManager.findFragmentById(R.id.nav_host_view) as NavHostFragment

        // Works as NavHostFragment already called onCreate()
        val navController = binding.navHostView.getFragment<NavHostFragment>().navController

        println("AAA NavigationActivity navController $navController")
    }
}
