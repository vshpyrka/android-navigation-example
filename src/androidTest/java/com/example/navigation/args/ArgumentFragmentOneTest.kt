package com.example.navigation.args

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArgumentFragmentOneTest {

    @Test
    fun testNavigateToArgsFragmentTwo() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        val scenario = launchFragmentInContainer<ArgumentFragmentOne>()
        scenario.onFragment {
            navController.setGraph(R.navigation.activity_args_nav_graph)
            Navigation.setViewNavController(it.requireView(), navController)
        }
        onView(ViewMatchers.withId(R.id.open_overwritten_action)).perform(click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.argumentFragmentTwo)
        scenario.close()
    }
}
