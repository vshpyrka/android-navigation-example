package com.example.navigation.destinations

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R

class DestinationFragmentOne : Fragment(R.layout.fragment_destination_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener(
            Navigation.createNavigateOnClickListener(
                DestinationFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentTwo()
            )
        )
    }
}
