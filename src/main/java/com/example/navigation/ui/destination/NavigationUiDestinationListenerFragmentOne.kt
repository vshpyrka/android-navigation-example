package com.example.navigation.ui.destination

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationUiDestinationListenerOneBinding
import com.example.navigation.getLoremIpsum

class NavigationUiDestinationListenerFragmentOne : Fragment(
    R.layout.fragment_navigation_ui_destination_listener_one
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationUiDestinationListenerOneBinding.bind(view)
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationUiDestinationListenerFragmentOneDirections.actionNavigationUiDestinationListenerFragmentOneToNavigationUiDestinationListenerFragmentTwo(
                    arg = 500
                )
            )
        )
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
