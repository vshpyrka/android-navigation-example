package com.example.navigation.dsl.nested

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDSLNestedGraphHomeBinding
import com.example.navigation.dsl.nav_graph
import com.example.navigation.getLoremIpsum

class NavigationDSLNestedGraphHomeFragment : Fragment(
    R.layout.fragment_navigation_d_s_l_nested_graph_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDSLNestedGraphHomeBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener {
            findNavController().navigate(
                nav_graph.dest.nested_graph_fragment_two
            )
        }
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
