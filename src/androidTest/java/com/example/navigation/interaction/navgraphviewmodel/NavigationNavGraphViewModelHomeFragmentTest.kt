package com.example.navigation.interaction.navgraphviewmodel

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelStore
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationNavGraphViewModelHomeFragmentTest {

    @Test
    fun testNavigationNavGraphViewModelFragmentOne() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        // To provide working test when there is nav graph ViewModel used
        val viewModelStore = ViewModelStore()
        navController.setViewModelStore(viewModelStore)
        val scenario = launchFragmentInContainer(
            themeResId = R.style.AppTheme_NoActionBar
        ) {
            // Set NavController before onViewCreated
            NavigationNavGraphViewModelHomeFragment().apply {
                viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        navController.setGraph(R.navigation.activity_navigation_nav_graph_viewmodel_nav_graph)
                        Navigation.setViewNavController(requireView(), navController)
                    }
                }
            }
        }
        onView(withId(R.id.button)).perform(click())
        assertThat(navController.currentDestination?.id)
            .isEqualTo(R.id.navigationNavGraphViewModelFragmentTwo)
        scenario.close()
    }
}
