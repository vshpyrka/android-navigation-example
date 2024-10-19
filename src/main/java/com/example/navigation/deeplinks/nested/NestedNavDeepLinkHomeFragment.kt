package com.example.navigation.deeplinks.nested

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNestedNavDeepLinkHomeBinding
import com.example.navigation.getLoremIpsum

class NestedNavDeepLinkHomeFragment : Fragment(R.layout.fragment_nested_nav_deep_link_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNestedNavDeepLinkHomeBinding.bind(view)
        binding.root.applyWindowInsets()
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
