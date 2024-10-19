package com.example.navigation.ui.drawer.nested

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDrawerSettingsBinding
import com.example.navigation.getLoremIpsum

class NavigationDrawerSettingsFragment : Fragment(R.layout.fragment_navigation_drawer_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDrawerSettingsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationDrawerSettingsFragmentDirections.actionNavigationDrawerSettingsFragmentToNavigationDrawerSettingsDetailsFragment()
            )
        )
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
