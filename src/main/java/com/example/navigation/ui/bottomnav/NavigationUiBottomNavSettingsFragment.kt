package com.example.navigation.ui.bottomnav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationUiBottomNavSettingsBinding
import com.example.navigation.getLoremIpsum

class NavigationUiBottomNavSettingsFragment : Fragment(
    R.layout.fragment_navigation_ui_bottom_nav_settings
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiBottomNavSettingsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.text = getLoremIpsum()
    }
}
