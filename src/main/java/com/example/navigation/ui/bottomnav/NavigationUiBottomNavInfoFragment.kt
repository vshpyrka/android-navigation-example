package com.example.navigation.ui.bottomnav

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationUiBottomNavInfoBinding
import com.example.navigation.getLoremIpsum

class NavigationUiBottomNavInfoFragment : Fragment(
    R.layout.fragment_navigation_ui_bottom_nav_info
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiBottomNavInfoBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationUiBottomNavInfoFragmentDirections.actionNavigationUiBottomNavInfoFragmentToNavigationUiBottomNavInfoDetailsFragment()
            )
        )
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
