package com.example.navigation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.ActivityNavigationUiBinding
import com.example.navigation.ui.actionbar.NavigationUiActionBarActivity
import com.example.navigation.ui.appbarvariations.NavigationUiAppBarVariationActivity
import com.example.navigation.ui.bottomnav.NavigationUiBottomNavActivity
import com.example.navigation.ui.collapsingtoolbar.CollapsingToolbarActivity
import com.example.navigation.ui.destination.NavigationUiDestinationListenerActivity
import com.example.navigation.ui.drawer.NavigationDrawerActivity
import com.example.navigation.ui.menuitems.NavigationMenuItemsActivity
import com.example.navigation.ui.toolbar.NavigationUiToolbarActivity

class NavigationUiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationUiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setOnClickListener {
            startActivity(Intent(this, NavigationUiToolbarActivity::class.java))
        }

        binding.collapsingToolbar.setOnClickListener {
            startActivity(Intent(this, CollapsingToolbarActivity::class.java))
        }
        binding.actionToolbar.setOnClickListener {
            startActivity(Intent(this, NavigationUiActionBarActivity::class.java))
        }
        binding.appBarVariations.setOnClickListener {
            startActivity(Intent(this, NavigationUiAppBarVariationActivity::class.java))
        }
        binding.menuItems.setOnClickListener {
            startActivity(Intent(this, NavigationMenuItemsActivity::class.java))
        }
        binding.drawer.setOnClickListener {
            startActivity(Intent(this, NavigationDrawerActivity::class.java))
        }
        binding.bottomNav.setOnClickListener {
            startActivity(Intent(this, NavigationUiBottomNavActivity::class.java))
        }
        binding.destination.setOnClickListener {
            startActivity(Intent(this, NavigationUiDestinationListenerActivity::class.java))
        }
    }
}
