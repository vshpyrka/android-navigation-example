package com.example.navigation.ui.appbarvariations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationUiAppBarVariationTwoBinding
import com.example.navigation.getLoremIpsum

class NavigationUiAppBarVariationFragmentTwo : Fragment(
    R.layout.fragment_navigation_ui_app_bar_variation_two
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiAppBarVariationTwoBinding.bind(view)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.text.text = getLoremIpsum()
    }
}
