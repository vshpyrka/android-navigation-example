package com.example.navigation.ui.appbarvariations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavigationUiAppBarVariationBinding

class NavigationUiAppBarVariationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationUiAppBarVariationBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)
    }
}
