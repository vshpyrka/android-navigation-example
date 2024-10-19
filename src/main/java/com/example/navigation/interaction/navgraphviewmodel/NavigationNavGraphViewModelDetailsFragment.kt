package com.example.navigation.interaction.navgraphviewmodel

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationNavGraphViewModelDetailsBinding
import com.example.navigation.getLoremIpsum

class NavigationNavGraphViewModelDetailsFragment :
    Fragment(R.layout.fragment_navigation_nav_graph_view_model_details) {

    // Retrieve viewModel instance scoped to nav graph
    private val viewModel by navGraphViewModels<GraphViewModel>(
        R.id.activity_navigation_nav_graph_viewmodel_nav_graph
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNavigationNavGraphViewModelDetailsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
        val title = "Current ViewModel Parameter - ${viewModel.parameter}"
        binding.title.text = title
        viewModel.parameter += "World"
    }
}
