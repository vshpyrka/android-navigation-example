package com.example.navigation.args

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityArgumentPassBinding

class ArgumentPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityArgumentPassBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        val navHostFragment = binding.container.getFragment<NavHostFragment>()
        navHostFragment.findNavController().apply {
            setGraph(
                R.navigation.activity_argument_pass_nav_graph,
                bundleOf("key" to "Hello World!")
            )
        }
    }
}
