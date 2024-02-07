package com.example.navigation.interaction.dynamicnavhost

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentDynamicNavHostHomeBinding
import com.example.navigation.getLoremIpsum
import com.google.android.material.snackbar.Snackbar

class DynamicNavHostHomeFragment : Fragment(R.layout.fragment_dynamic_nav_host_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDynamicNavHostHomeBinding.bind(view)
        binding.button.setOnClickListener {
            findNavController().navigate(
                DynamicNavHostHomeFragmentDirections.actionDynamicNavHostFragmentOneToDynamicNavHostFragmentTwo()
            )
        }

        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()

        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<String>("argument")
            ?.observe(viewLifecycleOwner) {
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
            }
    }
}
