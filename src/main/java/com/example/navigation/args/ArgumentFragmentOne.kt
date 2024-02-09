package com.example.navigation.args

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigation.R

class ArgumentFragmentOne : Fragment(R.layout.fragment_argument_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.open_overwritten_action).setOnClickListener {
            it.findNavController().navigate(
                ArgumentFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentTwo()
            )
        }
        view.findViewById<Button>(R.id.open_with_argument).setOnClickListener {
            it.findNavController().navigate(
                ArgumentFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentTwo(
                    argument = 100
                )
            )
        }
    }
}
