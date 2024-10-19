package com.example.navigation.ui.collapsingtoolbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class CollapsingToolbarFragmentTwo : Fragment(R.layout.fragment_collapsing_toolbar_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()
    }
}
