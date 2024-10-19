package com.example.navigation.deeplinks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavDeepLinkBinding

class NavDeepLinkActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavDeepLinkBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        val navHostFragment = binding.content.getFragment<NavHostFragment>()

        // Works as NavHostFragment already called onCreate()
        navController = navHostFragment.navController
    }

    // Should be present if we have different activity launch mode, like
    // android:launchMode="singleTop"

    //    override fun onNewIntent(intent: Intent?) {
    //        super.onNewIntent(intent)
    //        navController.handleDeepLink(intent)
    //    }
}
