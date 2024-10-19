package com.example.navigation.dsl.deeplink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.R
import com.example.navigation.databinding.ActivityNavigationDsldeepLinkBinding

/**
 * To launch

adb shell am start \
-W -a android.intent.action.VIEW \
-d "http://www.example.com/navigation/dsl/123?status=200"
 **/

class NavigationDSLDeepLinkActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNavigationDsldeepLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val baseUri = "http://www.example.com/navigation/dsl"

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navHostFragment.navController.apply {
            graph = createGraph(
                deep_link_graph.id,
                deep_link_graph.dest.destination_fragment_one
            ) {

                fragment<NavigationDSLDeepLinkHomeFragment>(deep_link_graph.dest.destination_fragment_one) {
                    label = "Navigation DSL Deep Link Home"
                }

                fragment<NavigationDSLDeepLinkDetailsFragment>(deep_link_graph.dest.destination_fragment_two) {
                    label = "Navigation DSL Deep Link Details"
                    deepLink("${baseUri}/{id}?status={status}")
                    argument(deep_link_graph.args.arg1) {
                        type = NavType.IntType
                    }
                    argument(deep_link_graph.args.arg2) {
                        type = NavType.IntType
                    }
                }
            }
        }
        appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
