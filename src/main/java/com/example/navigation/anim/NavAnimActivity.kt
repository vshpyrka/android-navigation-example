package com.example.navigation.anim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavAnimBinding

class NavAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavAnimBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
