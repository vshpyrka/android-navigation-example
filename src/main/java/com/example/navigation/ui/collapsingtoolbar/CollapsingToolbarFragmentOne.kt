package com.example.navigation.ui.collapsingtoolbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class CollapsingToolbarFragmentOne : Fragment(R.layout.fragment_collapsing_toolbar_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
        view.findViewById<View>(R.id.button).setOnClickListener(
            Navigation.createNavigateOnClickListener(
                CollapsingToolbarFragmentOneDirections.actionCollapsingToolbarFragmentOneToCollapsingToolbarFragmentTwo()
            )
        )
    }
}
