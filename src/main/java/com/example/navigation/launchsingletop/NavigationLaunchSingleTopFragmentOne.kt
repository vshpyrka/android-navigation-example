package com.example.navigation.launchsingletop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class NavigationLaunchSingleTopFragmentOne : Fragment(R.layout.fragment_navigation_launch_single_top_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
        view.findViewById<View>(R.id.button).setOnClickListener {
            findNavController().navigate(R.id.navigationLaunchSingleTopFragmentTwo)
        }
    }
}
