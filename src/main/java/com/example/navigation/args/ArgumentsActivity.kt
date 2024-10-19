package com.example.navigation.args

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityArgumentsBinding

class ArgumentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityArgumentsBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)
    }
}
