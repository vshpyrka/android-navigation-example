package com.example.navigation.ui.destination

import androidx.navigation.findNavController
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiDestinationListenerActivityTest {

    @Test
    fun testNavigationUiDestinationListenerActivity() {
        val scenario = launchActivity<NavigationUiDestinationListenerActivity>()
        var argumentValue: Int = -1
        scenario.onActivity {
            val navController = it.findNavController(R.id.container)
            navController.addOnDestinationChangedListener { _, _, arguments ->
                argumentValue = arguments?.getInt("arg", -1) ?: -1
            }
        }

        onView(withId(R.id.button)).perform(click())
        Assert.assertEquals(500, argumentValue)
        onView(withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso.pressBackUnconditionally()
        scenario.close()
    }
}
