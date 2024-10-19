package com.example.navigation.interaction.modifygraph

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationModifyNavGraphInfoBinding
import com.example.navigation.getLoremIpsum

class NavigationModifyNavGraphInfoFragment : Fragment(
    R.layout.fragment_navigation_modify_nav_graph_info
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationModifyNavGraphInfoBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
