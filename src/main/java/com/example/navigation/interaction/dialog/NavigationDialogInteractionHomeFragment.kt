package com.example.navigation.interaction.dialog

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDialogInteractionHomeBinding
import com.example.navigation.getLoremIpsum

class NavigationDialogInteractionHomeFragment : Fragment(
    R.layout.fragment_navigation_dialog_interaction_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNavigationDialogInteractionHomeBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener {
            it.findNavController()
                .navigate(
                    NavigationDialogInteractionHomeFragmentDirections.actionNavigationDialogInteractionFragmentOneToNavigationDialogInteractionFragmentTwo()
                )
        }
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
