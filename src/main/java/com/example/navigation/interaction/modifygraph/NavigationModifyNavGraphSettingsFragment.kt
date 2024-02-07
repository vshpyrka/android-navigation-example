package com.example.navigation.interaction.modifygraph

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationModifyNavGraphSettingsBinding
import com.example.navigation.getLoremIpsum

class NavigationModifyNavGraphSettingsFragment : Fragment(
    R.layout.fragment_navigation_modify_nav_graph_settings
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNavigationModifyNavGraphSettingsBinding.bind(view)
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
