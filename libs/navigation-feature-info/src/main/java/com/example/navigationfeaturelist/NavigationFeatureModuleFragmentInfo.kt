package com.example.navigationfeaturelist

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.navigationfeaturelist.databinding.FragmentNavigationFeatureModuleInfoBinding

class NavigationFeatureModuleFragmentInfo : Fragment(
    R.layout.fragment_navigation_feature_module_info
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNavigationFeatureModuleInfoBinding.bind(view)
        binding.button.setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://com.example.navigation/settings_fragment_two".toUri())
                .build()
            findNavController().navigate(
                request
            )
        }
    }
}
