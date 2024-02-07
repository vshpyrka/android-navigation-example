package com.example.navigation.included

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigation.R

class SecondNavigationFragmentOne : Fragment(R.layout.fragment_second_navigation_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            it.findNavController()
                .navigate(SecondNavigationFragmentOneDirections.actionSecondNavigationFragmentOneToNavigation())
        }
    }

}
