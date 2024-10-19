package com.example.navigation.destinations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityDestinationsBinding

class DestinationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDestinationsBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)
    }
}
