package com.example.navigation.dsl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.R as navigationR
import com.example.navigation.dsl.nested.NavigationDSLNestedGraphHomeFragment
import com.example.navigation.dsl.nested.NavigationDSLNestedGraphDetailsFragment
import com.example.navigation.R

class NavigationDSLActivity : AppCompatActivity(R.layout.activity_navigation_dslactivity) {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment

        navHostFragment.navController.apply {
            graph = createGraph(
                nav_graph.id,
                nav_graph.dest.home
            ) {
                fragment<NavigationDSLFragmentOne>(nav_graph.dest.home) {
                    label = "Home"
                    action(nav_graph.action.to_detail) {
                        destinationId = nav_graph.id
                    }
                }
                fragment<NavigationDSLFragmentTwo>(nav_graph.dest.detail) {
                    label = "Details"
                    argument(nav_graph.args.id) {
                        type = NavType.StringType
                        nullable = false
                        defaultValue = "defaultValue"
                    }
                }

                // Activity Destination
                activity(nav_graph.dest.activity) {
                    activityClass = NavigationDSLActivityDestination::class
                }

                // Nested Nav Graph
                navigation(
                    nav_graph.nested_graph,
                    nav_graph.dest.nested_graph_fragment_one,
                ) {
                    fragment<NavigationDSLNestedGraphHomeFragment>(nav_graph.dest.nested_graph_fragment_one) {
                        label = "Nested DSL Graph Home"
                        action(nav_graph.action.to_nested_two) {
                            destinationId = nav_graph.dest.nested_graph_fragment_two
                        }
                    }
                    fragment<NavigationDSLNestedGraphDetailsFragment>(nav_graph.dest.nested_graph_fragment_two) {
                        label = "Nested DSL Graph Details"
                    }
                }
                // Global action
                action(nav_graph.action.to_detail) {
                    destinationId = nav_graph.dest.detail
                    navOptions {
                        anim {
                            enter = navigationR.anim.nav_default_enter_anim
                            exit = navigationR.anim.nav_default_exit_anim
                            popEnter = navigationR.anim.nav_default_pop_enter_anim
                            popExit = navigationR.anim.nav_default_pop_exit_anim
                        }
                        popUpTo(nav_graph.dest.home) {
                            inclusive = true // default false
                        }
                        // if popping exclusively, you can specify popUpTo as
                        // a property. e.g. popUpTo = nav_graph.dest.start_dest
                        launchSingleTop = true // default false
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
