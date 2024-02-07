package com.example.navigation.deeplinks.nested

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNestedNavDeepLinkDetailsBinding

class NestedNavDeepLinkDetailsFragment : Fragment(R.layout.fragment_nested_nav_deep_link_details) {

    private val args: NestedNavDeepLinkDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNestedNavDeepLinkDetailsBinding.bind(view)
        val message = "Received Deeplink Arguments: \nid=${args.id} \nstatus=${args.status}"
        binding.text.text = message
    }
}
