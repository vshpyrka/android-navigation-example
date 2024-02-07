package com.example.navigation.args

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentArgumentTwoBinding

class ArgumentFragmentTwo : Fragment(R.layout.fragment_argument_two) {

    private val navArgs: ArgumentFragmentTwoArgs by navArgs()

    private var _binding: FragmentArgumentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentArgumentTwoBinding.bind(view)
        binding.text.text = navArgs.argument.toString()
        view.findViewById<Button>(R.id.button).setOnClickListener {
            it.findNavController()
                .navigate(
                    ArgumentFragmentTwoDirections.actionArgumentFragmentTwoToArgumentPassActivity()
                )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
