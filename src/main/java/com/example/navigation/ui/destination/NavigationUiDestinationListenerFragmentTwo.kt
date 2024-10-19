package com.example.navigation.ui.destination

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationUiDestinationListenerTwoBinding
import com.example.navigation.getLoremIpsum

class NavigationUiDestinationListenerFragmentTwo : Fragment(
    R.layout.fragment_navigation_ui_destination_listener_two
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiDestinationListenerTwoBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
