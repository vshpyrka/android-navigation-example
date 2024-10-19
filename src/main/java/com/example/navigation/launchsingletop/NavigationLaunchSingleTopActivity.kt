package com.example.navigation.launchsingletop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.ActivityNavigationLaunchSingleTopBinding

class NavigationLaunchSingleTopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationLaunchSingleTopBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
