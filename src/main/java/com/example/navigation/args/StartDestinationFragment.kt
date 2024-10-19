package com.example.navigation.args

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentStartDestinationBinding

class StartDestinationFragment : Fragment(R.layout.fragment_start_destination) {

    private val args by navArgs<StartDestinationFragmentArgs>()

    private var _binding: FragmentStartDestinationBinding? = null
    private val binding: FragmentStartDestinationBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("AAA $arguments")
        println("AAA ${findNavController()}")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("AAA 2 ${findNavController()}")
        _binding = FragmentStartDestinationBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.text = args.key
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
