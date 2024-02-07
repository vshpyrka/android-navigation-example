package com.example.navigation.dsl.deeplink

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNavigationDSLDeepLinkHomeBinding
import com.example.navigation.getLoremIpsum

class NavigationDSLDeepLinkHomeFragment : Fragment(
    R.layout.fragment_navigation_d_s_l_deep_link_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationDSLDeepLinkHomeBinding.bind(view)
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
