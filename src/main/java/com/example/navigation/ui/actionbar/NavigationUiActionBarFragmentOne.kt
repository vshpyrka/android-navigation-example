package com.example.navigation.ui.actionbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R

class NavigationUiActionBarFragmentOne : Fragment(R.layout.fragment_navigation_ui_action_bar_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.button).setOnClickListener(
            Navigation.createNavigateOnClickListener(NavigationUiActionBarFragmentOneDirections.actionNavigationUiActionBarFragmentOneToNavigationUiActionBarFragmentTwo())
        )
    }
}
