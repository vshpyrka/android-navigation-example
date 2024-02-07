package com.example.navigation.launchsingletop

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationLaunchSingleTopFragmentOneTest {

    @Test
    fun testNavigationLaunchFragmentTwo() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        val scenario = launchFragmentInContainer<NavigationLaunchSingleTopFragmentOne>()
        scenario.onFragment {
            navController.setGraph(R.navigation.activity_navigation_launch_single_top)
            Navigation.setViewNavController(it.requireView(), navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())
        Truth.assertThat(navController.currentDestination?.id)
            .isEqualTo(R.id.navigationLaunchSingleTopFragmentTwo)
        scenario.close()
    }
}
