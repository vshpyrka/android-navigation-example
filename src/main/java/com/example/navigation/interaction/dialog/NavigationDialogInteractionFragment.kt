package com.example.navigation.interaction.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDialogInteractionBinding

class NavigationDialogInteractionFragment : DialogFragment(
    R.layout.fragment_navigation_dialog_interaction
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNavigationDialogInteractionBinding.bind(view)
        binding.root.applyWindowInsets()

        val navController = findNavController()

        binding.set.setOnClickListener {
            navController.previousBackStackEntry?.savedStateHandle?.set("key", "Hello")
        }
    }
}
