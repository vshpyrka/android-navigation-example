package com.example.navigation.destinations

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class DestinationFragmentTwo : Fragment(R.layout.fragment_destination_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
        view.findViewById<Button>(R.id.button).setOnClickListener {
            it.findNavController().navigate(
                DestinationFragmentTwoDirections.actionDestinationFragmentTwoToDestinationFragmentOne(),
//                R.id.destinationFragmentOne,
//                null,
//                navOptions { // overrides what is specified in xml
//                    anim {
//                        enter = R.animator.nav_default_enter_anim
//                        exit = R.animator.nav_default_exit_anim
//                        popEnter = R.animator.nav_default_pop_enter_anim
//                        popExit = R.animator.nav_default_pop_exit_anim
//                    }
//                    popUpTo(
//                        R.id.destinationFragmentOne
//                    ) {
//                        inclusive = true
//                    }
//                }
            )
        }
    }
}
