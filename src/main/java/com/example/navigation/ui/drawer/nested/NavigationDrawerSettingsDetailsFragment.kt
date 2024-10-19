package com.example.navigation.ui.drawer.nested

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDrawerSettingsDetailsBinding
import com.example.navigation.getLoremIpsum

class NavigationDrawerSettingsDetailsFragment : Fragment(
    R.layout.fragment_navigation_drawer_settings_details
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDrawerSettingsDetailsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
