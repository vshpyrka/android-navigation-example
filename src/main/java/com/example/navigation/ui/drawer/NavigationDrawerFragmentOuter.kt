package com.example.navigation.ui.drawer

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationDrawerOuterBinding
import com.example.navigation.getLoremIpsum

class NavigationDrawerFragmentOuter : Fragment(R.layout.fragment_navigation_drawer_outer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDrawerOuterBinding.bind(view)
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
