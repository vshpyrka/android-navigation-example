package com.example.navigation.anim

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
class NavAnimFragmentOneTest {

    @Test
    fun testNavigationToAnimFragmentTwo() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragmentInContainer<NavAnimFragmentOne>()
        scenario.onFragment {
            navController.setGraph(R.navigation.activity_nav_anim)
            Navigation.setViewNavController(it.requireView(), navController)
        }
        onView(withId(R.id.image_view)).perform(click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navAnimFragmentTwo)
        scenario.close()
    }
}
