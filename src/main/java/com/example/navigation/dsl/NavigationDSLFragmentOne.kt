package com.example.navigation.dsl

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDSLOneBinding
import com.example.navigation.getLoremIpsum

class NavigationDSLFragmentOne : Fragment(R.layout.fragment_navigation_d_s_l_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDSLOneBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener {
            findNavController().navigate(
                nav_graph.dest.detail,
                bundleOf(
                    nav_graph.args.id to "Hello!"
                )
            )
        }
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
