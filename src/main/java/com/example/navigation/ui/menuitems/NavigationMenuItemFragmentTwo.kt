package com.example.navigation.ui.menuitems

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationMenuItemTwoBinding
import com.example.navigation.getLoremIpsum

class NavigationMenuItemFragmentTwo : Fragment(R.layout.fragment_navigation_menu_item_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationMenuItemTwoBinding.bind(view)
        binding.text.text = getLoremIpsum()
    }
}
