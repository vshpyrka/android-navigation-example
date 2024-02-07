package com.example.navigation.destinations

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DestinationFragmentOneTest {

    @Test
    fun testNavigateToDestinationFragmentTwo() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        val scenario = launchFragmentInContainer<DestinationFragmentOne>()
        scenario.onFragment {
            navController.setGraph(R.navigation.activity_destinations_nav_graph)
            Navigation.setViewNavController(it.requireView(), navController)
        }
        onView(ViewMatchers.withId(R.id.button)).perform(click())
        Truth.assertThat(navController.currentDestination?.id)
            .isEqualTo(R.id.destinationFragmentTwo)
        scenario.close()
    }
}
