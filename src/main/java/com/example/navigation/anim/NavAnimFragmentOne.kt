package com.example.navigation.anim

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.navigation.R
import com.example.navigation.applyWindowInsets

class NavAnimFragmentOne : Fragment(R.layout.fragment_nav_anim_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applyWindowInsets()

        val image = view.findViewById<View>(R.id.image_view)
        ViewCompat.setTransitionName(image, "item_view")

        view.findViewById<View>(R.id.image_view).setOnClickListener {
            val extras = FragmentNavigatorExtras(
                it to "custom_view"
            )
            it.findNavController().navigate(
                R.id.navAnimFragmentTwo,
                null,
                null,
                extras
            )
        }
    }
}
