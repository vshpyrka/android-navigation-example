package com.example.navigation.ui.menuitems

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationMenuItemOneBinding
import com.example.navigation.getLoremIpsum

class NavigationMenuItemFragmentOne : Fragment(R.layout.fragment_navigation_menu_item_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationMenuItemOneBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.text = getLoremIpsum()
    }
}
