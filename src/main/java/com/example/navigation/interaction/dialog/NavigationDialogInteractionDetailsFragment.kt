package com.example.navigation.interaction.dialog

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationDialogInteractionDetailsBinding
import com.example.navigation.getLoremIpsum
import com.google.android.material.snackbar.Snackbar

class NavigationDialogInteractionDetailsFragment : Fragment(
    R.layout.fragment_navigation_dialog_interaction_details
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNavigationDialogInteractionDetailsBinding.bind(view)
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()

        val navController = findNavController()

        // Can return dialog fragment when configuration change happens
        val currentBackStackEntry = navController.currentBackStackEntry
        println("AAA $currentBackStackEntry")

        // Will not work for displayed dialog over it and after configuration change
        /*
        currentBackStackEntry?.savedStateHandle
            ?.getLiveData<String>("key")
            ?.observe(viewLifecycleOwner) {
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
            }
        */


        // After a configuration change or process death, the currentBackStackEntry
        // points to the dialog destination, so you must use getBackStackEntry()
        // with the specific ID of your destination to ensure we always
        // get the right NavBackStackEntry
        val backStackEntry =
            navController.getBackStackEntry(R.id.navigationDialogInteractionFragmentTwo)

        /*
        backStackEntry.savedStateHandle
            .getLiveData<String>("key")
            .observe(viewLifecycleOwner) {
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
            }
         */

        // Create our observer and add it to the NavBackStackEntry's lifecycle
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME
                && backStackEntry.savedStateHandle.contains("key")
            ) {
                val result = backStackEntry.savedStateHandle.get<String>("key")
                backStackEntry.savedStateHandle.remove<String>("key")
                result?.run {
                    Snackbar.make(view, this, Snackbar.LENGTH_LONG).show()
                }
            }
        }
        backStackEntry.lifecycle.addObserver(observer)

        // As addObserver() does not automatically remove the observer, we
        // call removeObserver() manually when the view lifecycle is destroyed
        viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                backStackEntry.lifecycle.removeObserver(observer)
            }
        })

        binding.button.setOnClickListener {
            it.findNavController()
                .navigate(
                    NavigationDialogInteractionDetailsFragmentDirections.actionNavigationDialogInteractionFragmentTwoToNavigationDialogInteractionFragment()
                )
        }
    }
}
