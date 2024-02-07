package com.example.navigation.ui.drawer

import androidx.fragment.app.testing.launchFragmentInContainer
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
class NavigationDrawerInfoFragmentTest {

    @Test
    fun testNavigationDrawerFragmentThree() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragmentInContainer<NavigationDrawerInfoFragment>()
        scenario.onFragment {
            navController.setGraph(R.navigation.activity_navigation_drawer_nav_graph)
            navController.navigate(R.id.info)
            Navigation.setViewNavController(it.requireView(), navController)
        }

        onView(withId(R.id.button)).perform(click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navigationDrawerFragmentOuter)
        scenario.close()
    }
}
