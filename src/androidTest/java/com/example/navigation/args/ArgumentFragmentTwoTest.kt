package com.example.navigation.args

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import junit.framework.AssertionFailedError
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArgumentFragmentTwoTest {

    @Test
    fun testNavigateToArgsActivity() {
        val navController =
            TestNavHostController(ApplicationProvider.getApplicationContext()).apply {
                UiThreadStatement.runOnUiThread {
                    setGraph(R.navigation.activity_args_nav_graph)
                    setCurrentDestination(R.id.argumentFragmentTwo)
                }
            }

        // Pass empty arguments for proper handling of " by navArgs() " call
        val scenario = launchFragmentInContainer<ArgumentFragmentTwo>(bundleOf())
        scenario.onFragment {
            Navigation.setViewNavController(it.requireView(), navController)
        }
        onView(withId(R.id.button)).perform(click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.argumentPassActivity)
        scenario.close()
    }

    @Test
    fun testArgumentFragmentTwoArgsPass() {
        val navController =
            TestNavHostController(ApplicationProvider.getApplicationContext()).apply {
                UiThreadStatement.runOnUiThread {
                    setGraph(R.navigation.activity_args_nav_graph)
                    setCurrentDestination(R.id.argumentFragmentTwo)
                }
            }
        val scenario = launchFragmentInContainer<ArgumentFragmentTwo>(
            bundleOf("argument" to 2)
        )
        scenario.onFragment {
            Navigation.setViewNavController(it.requireView(), navController)
        }
        onView(withId(R.id.text)).check(matches(withText("2")))
        scenario.close()
    }

    @Test(expected = AssertionFailedError::class)
    fun testArgumentFragmentTwoArgsPassFail() {
        val navController =
            TestNavHostController(ApplicationProvider.getApplicationContext()).apply {
                UiThreadStatement.runOnUiThread {
                    setGraph(R.navigation.activity_args_nav_graph)
                    setCurrentDestination(R.id.argumentFragmentTwo)
                }
            }
        val scenario = launchFragmentInContainer<ArgumentFragmentTwo>(
            bundleOf("argument" to 2)
        )
        scenario.onFragment {
            Navigation.setViewNavController(it.requireView(), navController)
        }
        onView(withId(R.id.text)).check(matches(withText("3")))
        scenario.close()
    }
}
