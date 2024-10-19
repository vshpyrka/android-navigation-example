package com.example.navigation.ui.bottomnav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationUiBottomNavInfoDetailsBinding

class NavigationUiBottomNavInfoDetailsFragment : Fragment(
    R.layout.fragment_navigation_ui_bottom_nav_info_details
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiBottomNavInfoDetailsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
