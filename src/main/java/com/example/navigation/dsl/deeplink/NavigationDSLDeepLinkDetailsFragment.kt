package com.example.navigation.dsl.deeplink

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.FragmentNavigationDSLDeepLinkDetailsBinding
import com.example.navigation.getLoremIpsum

class NavigationDSLDeepLinkDetailsFragment : Fragment(
    R.layout.fragment_navigation_d_s_l_deep_link_details
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt(deep_link_graph.args.arg1)
        val status = arguments?.getInt(deep_link_graph.args.arg2)
        val binding = FragmentNavigationDSLDeepLinkDetailsBinding.bind(view)
        binding.root.applyWindowInsets()
        val message = "DSL Deep Link Details Arg \n id = $id status = $status"
        binding.title.text = message
        binding.text.movementMethod = ScrollingMovementMethod()
        binding.text.text = getLoremIpsum()
    }
}
