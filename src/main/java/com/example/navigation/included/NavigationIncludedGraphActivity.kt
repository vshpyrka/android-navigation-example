package com.example.navigation.included

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityIncludedGraphNavigationBinding

class NavigationIncludedGraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIncludedGraphNavigationBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)
    }
}
