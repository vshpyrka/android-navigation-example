package com.example.navigation.ui.actionbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class NavigationUiActionBarFragmentTwo : Fragment(R.layout.fragment_navigation_ui_action_bar_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
    }
}
