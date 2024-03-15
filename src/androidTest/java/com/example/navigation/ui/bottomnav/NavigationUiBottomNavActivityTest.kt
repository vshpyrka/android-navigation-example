package com.example.navigation.ui.bottomnav

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiBottomNavActivityTest {

    @Test
    fun testNavigationUiBottomNavActivity() {
        val scenario = launchActivity<NavigationUiBottomNavActivity>()
        onView(withId(R.id.info)).perform(click())
        onView(
            Matchers.allOf(
                withText("Info"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())
        onView(
            Matchers.allOf(
                withText("Info Details"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withText("Back")).perform(click())
        onView(
            Matchers.allOf(
                withText("Info"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())
        onView(
            Matchers.allOf(
                withText("Info Details"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        onView(withId(R.id.settings)).perform(click())
        onView(
            Matchers.allOf(
                withText("Settings"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        scenario.close()
    }
}
