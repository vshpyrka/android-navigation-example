package com.example.navigation.ui.appbarvariations

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationUiAppBarVariationOneBinding
import com.example.navigation.getLoremIpsum

class NavigationUiAppBarVariationFragmentOne : Fragment(
    R.layout.fragment_navigation_ui_app_bar_variation_one
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiAppBarVariationOneBinding.bind(view)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationUiAppBarVariationFragmentOneDirections.actionNavigationUiAppBarVariationFragmentOneToNavigationUiAppBarVariationFragmentTwo()
            )
        )
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
