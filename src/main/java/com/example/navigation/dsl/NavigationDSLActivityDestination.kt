package com.example.navigation.dsl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.ActivityNavigationDsldestinationBinding

class NavigationDSLActivityDestination : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationDsldestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
