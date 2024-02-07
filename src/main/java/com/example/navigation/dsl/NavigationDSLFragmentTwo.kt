package com.example.navigation.dsl

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationDSLTwoBinding
import com.example.navigation.getLoremIpsum

class NavigationDSLFragmentTwo : Fragment(R.layout.fragment_navigation_d_s_l_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argument = arguments?.getString(nav_graph.args.id) ?: ""

        val binding = FragmentNavigationDSLTwoBinding.bind(view)
        val text = "DSL Destination ARG - $argument"
        binding.title.text = text
        binding.button.setOnClickListener {
            findNavController().navigate(
                nav_graph.nested_graph
            )
        }
        binding.text.text = getLoremIpsum()
    }
}
