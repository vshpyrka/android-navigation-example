package com.example.navigation.deeplinks.explicit

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.NavDeepLinkBuilder
import com.example.navigation.R
import com.example.navigation.applyWindowInsets
import com.example.navigation.databinding.ActivityNavigationExplicitDeepLinkBinding
import com.example.navigation.deeplinks.NavDeepLinkActivity

class NavigationExplicitDeepLinkActivity : AppCompatActivity() {

    companion object {
        const val KEY_FIRST = "FIRST"
        const val KEY_SECOND = "SECOND"
        const val KEY_THIRD = "THIRD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavigationExplicitDeepLinkBinding.inflate(layoutInflater)
        binding.root.applyWindowInsets()
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                val requestPermissionLauncher =
                    registerForActivityResult(
                        ActivityResultContracts.RequestPermission()
                    ) { isGranted: Boolean ->
                        if (isGranted) {
                            // Permission is granted. Continue the action or workflow in your
                            // app.
                            launch()
                        } else {
                            // Explain to the user that the feature is unavailable because the
                            // features requires a permission that the user has denied. At the
                            // same time, respect the user's decision. Don't link to system
                            // settings in an effort to convince the user to change their
                            // decision.
                        }
                    }

                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                launch()
            }
        } else {
            launch()
        }
    }

    private fun launch() {
        val key = intent.getStringExtra(KEY_FIRST) ?: "value"
        val id = intent.getIntExtra(KEY_SECOND, 1)
        val status = intent.getIntExtra(KEY_THIRD, 200)
        launchExplicitDeepLinkNotification(key, id, status)
    }

    private fun launchExplicitDeepLinkNotification(key: String, id: Int, status: Int) {
        val pendingIntent = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.activity_nav_deep_link_nav_graph)
            .setDestination(R.id.nestedNavDeepLinkFragmentTwo)
            .setArguments(
                bundleOf(
                    "key" to key,
                    "id" to id,
                    "status" to status
                )
            )
            .setComponentName(NavDeepLinkActivity::class.java)
            .createPendingIntent()


        createNotificationChannel()

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_settings)
            .setContentTitle("My app")
            .setContentText("Explicit NavGraph DeepLink")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        builder.setContentIntent(pendingIntent)
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1001, builder.build())
        }
    }

    private val CHANNEL_ID = "123123"

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel Name"
            val descriptionText = "Channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
