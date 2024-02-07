package com.example.navigation.ui.drawer

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationDrawerInfoBinding
import com.example.navigation.getLoremIpsum

class NavigationDrawerInfoFragment : Fragment(R.layout.fragment_navigation_drawer_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDrawerInfoBinding.bind(view)
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationDrawerInfoFragmentDirections.actionNavigationDrawerInfoFragmentToNavigationDrawerFragmentOuter()
            )
        )
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
