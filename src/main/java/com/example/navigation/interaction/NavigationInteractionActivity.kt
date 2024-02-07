package com.example.navigation.interaction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.ActivityNavigationInteractionBinding
import com.example.navigation.interaction.dialog.NavigationDialogInteractionActivity
import com.example.navigation.interaction.dynamicnavhost.DynamicNavHostActivity
import com.example.navigation.interaction.modifygraph.NavigationModifyNavGraphActivity
import com.example.navigation.interaction.navgraphviewmodel.NavigationNavGraphViewModelActivity

class NavigationInteractionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dynamicNavHost.setOnClickListener {
            startActivity(Intent(this, DynamicNavHostActivity::class.java))
        }

        binding.dialogDestination.setOnClickListener {
            startActivity(Intent(this, NavigationDialogInteractionActivity::class.java))
        }

        binding.navGraphViewModel.setOnClickListener {
            startActivity(Intent(this, NavigationNavGraphViewModelActivity::class.java))
        }

        binding.modifyNavGraph.setOnClickListener {
            startActivity(Intent(this, NavigationModifyNavGraphActivity::class.java))
        }
    }
}
