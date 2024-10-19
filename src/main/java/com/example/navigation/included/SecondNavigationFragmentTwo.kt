package com.example.navigation.included

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class SecondNavigationFragmentTwo : Fragment(R.layout.fragment_second_navigation_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
    }
}
