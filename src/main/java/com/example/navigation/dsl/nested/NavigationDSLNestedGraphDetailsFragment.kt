package com.example.navigation.dsl.nested

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDSLNestedGraphDetailsBinding
import com.example.navigation.getLoremIpsum

class NavigationDSLNestedGraphDetailsFragment : Fragment(
    R.layout.fragment_navigation_d_s_l_nested_graph_details
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDSLNestedGraphDetailsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
