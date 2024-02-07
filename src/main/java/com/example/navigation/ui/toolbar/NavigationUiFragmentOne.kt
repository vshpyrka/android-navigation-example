package com.example.navigation.ui.toolbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R

class NavigationUiFragmentOne : Fragment(R.layout.fragment_navigation_ui_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.button).setOnClickListener(
            Navigation.createNavigateOnClickListener(NavigationUiFragmentOneDirections.actionNavigationUiFragmentOneToNavigationUiFragmentTwo())
        )
    }
}
