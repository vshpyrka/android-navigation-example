package com.example.navigation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigation.databinding.FragmentNavigationLauncherBinding

class NavigationLauncherFragment : Fragment(R.layout.fragment_navigation_launcher) {

    private var _binding: FragmentNavigationLauncherBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("AAA FragmentTwo onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("AAA FragmentTwo onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNavigationLauncherBinding.bind(view)
        binding.includedGraph.setOnClickListener {
            it.findNavController()
                .navigate(
                    NavigationLauncherFragmentDirections.actionFragmentLauncherToIncludedGraphNavigationActivity()
                )
        }
        binding.destinations.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToDestinationsActivity()
            )
        )
        binding.browsable.setOnClickListener {
            it.findNavController()
                .navigate(
                    NavigationLauncherFragmentDirections.actionFragmentLauncherToBrowsableActivity(
                        "123"
                    )
                )
        }
        binding.explicitDeepLink.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToNavigationExplicitDeepLinkActivity()
            )
        )
        binding.arguments.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToArgumentsActivity()
            )
        )
        binding.animation.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToNavAnimActivity()
            )
        )
        binding.ui.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToNavigationUiActivity()
            )
        )
        binding.dsl.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToNavigationDSLActivity()
            )
        )
        binding.interaction.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToInteractionNavHostActivity()
            )
        )

        binding.modules.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToFeatureModuleNavigationActivity()
            )
        )

        binding.launchSingleTop.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                NavigationLauncherFragmentDirections.actionFragmentLauncherToNavigationLaunchSingleTopActivity()
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
