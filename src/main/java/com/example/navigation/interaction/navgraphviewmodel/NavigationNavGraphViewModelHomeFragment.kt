package com.example.navigation.interaction.navgraphviewmodel

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationNavGraphViewModelHomeBinding
import com.example.navigation.getLoremIpsum

class NavigationNavGraphViewModelHomeFragment : Fragment(
    R.layout.fragment_navigation_nav_graph_view_model_home
) {

    // Retrieve viewModel instance scoped to nav graph
    private val viewModel by navGraphViewModels<GraphViewModel>(
        R.id.activity_navigation_nav_graph_viewmodel_nav_graph
    )

    private var _binding: FragmentNavigationNavGraphViewModelHomeBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentNavigationNavGraphViewModelHomeBinding.bind(view)
        binding.button.setOnClickListener {

            viewModel.parameter = "Hello!"

            it.findNavController()
                .navigate(
                    NavigationNavGraphViewModelHomeFragmentDirections.actionNavigationNavGraphViewModelFragmentOneToNavigationNavGraphViewModelFragmentTwo()
                )
        }

        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.parameter.isEmpty()) {
            val title = "Open NavHost Scoped ViewModel Home"
            binding.title.text = title
        } else {
            val title = "New NavHost Scoped ViewModel Value - ${viewModel.parameter}"
            binding.title.text = title
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
