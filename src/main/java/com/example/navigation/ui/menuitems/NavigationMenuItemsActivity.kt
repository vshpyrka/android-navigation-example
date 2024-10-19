package com.example.navigation.ui.menuitems

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavigationMenuItemsBinding

class NavigationMenuItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationMenuItemsBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        val navHostFragment = binding.container.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolBar.setupWithNavController(navController, appBarConfiguration)

        toolBar.inflateMenu(R.menu.menu_navigation_items)

        toolBar.setOnMenuItemClickListener {
            it.onNavDestinationSelected(findNavController(R.id.container))
        }
    }
}
