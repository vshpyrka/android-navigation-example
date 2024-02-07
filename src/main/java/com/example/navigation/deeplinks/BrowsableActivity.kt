package com.example.navigation.deeplinks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.navigation.R
import com.example.navigation.databinding.ActivityBrowsableBinding


/**
 * To launch

adb shell am start \
-W -a android.intent.action.VIEW \
-d "example://gizmos" com.example.myapplication

adb shell am start \
-W -a android.intent.action.VIEW \
-d "http://www.example.com/gizmos?status=200"

 */
class BrowsableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBrowsableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowsableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { newIntent ->
            handleIntent(newIntent)
        }
    }

    private fun handleIntent(intent: Intent) {
        val data = intent.data
        val action = intent.action

        val status = data?.getQueryParameter("status")
        val text = "action=$action, \ndata=$data, \ncode=$status"
        binding.text.text = text
    }
}
