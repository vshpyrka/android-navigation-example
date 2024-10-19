package com.example.navigation.ui.toolbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class NavigationUiFragmentTwo : Fragment(R.layout.fragment_navigation_ui_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
    }
}
