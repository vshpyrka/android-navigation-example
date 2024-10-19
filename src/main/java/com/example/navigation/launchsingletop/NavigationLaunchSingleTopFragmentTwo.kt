package com.example.navigation.launchsingletop

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationLaunchSingleTopTwoBinding
import kotlin.random.Random

/**
 * Fragment navigates to itself with specified launchSingleTop=true, consequently it replace itself with new arguments data
 */
class NavigationLaunchSingleTopFragmentTwo : Fragment(
    R.layout.fragment_navigation_launch_single_top_two
) {

    private val colors = listOf(
        Color.CYAN,
        Color.BLACK,
        Color.DKGRAY,
        Color.BLUE,
        Color.GREEN,
        Color.LTGRAY,
        Color.MAGENTA,
        Color.RED,
        Color.YELLOW
    )

    private val randomColor: Int get() = Random.nextInt(8)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationLaunchSingleTopTwoBinding.bind(view)
        binding.root.applyWindowInsets()

        val key = "KEY_COLOR"
        val argument = arguments?.getInt(key, 0) ?: 0

        binding.root.setBackgroundColor(colors[argument])

        binding.button.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigationLaunchSingleTopFragmentTwo_self,
                bundleOf(key to randomColor)
            )
        }
    }
}
