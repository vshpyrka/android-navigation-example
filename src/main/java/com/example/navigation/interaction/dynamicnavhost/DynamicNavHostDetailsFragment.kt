package com.example.navigation.interaction.dynamicnavhost

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentDynamicNavHostDetailsBinding
import com.example.navigation.getLoremIpsum

class DynamicNavHostDetailsFragment : Fragment(R.layout.fragment_dynamic_nav_host_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDynamicNavHostDetailsBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.button.setOnClickListener {
            val previousBackStackEntry = findNavController().previousBackStackEntry
            previousBackStackEntry?.savedStateHandle?.set("argument", "Hello")
            findNavController().popBackStack()
        }
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
