package com.example.navigation.launchsingletop

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationLaunchSingleTopActivityTest {

    @Test
    fun testSelfNavigation() {
        launchActivity<NavigationLaunchSingleTopActivity>().use {
            onView(withId(R.id.button)).check(matches(withText("Button")))
            onView(withId(R.id.button)).perform(click())
            val text = "Hello blank fragment"
            onView(withId(R.id.button)).check(matches(withText(text + "0")))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.button)).check(matches(withText(text + "1")))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.button)).check(matches(withText(text + "2")))
            Espresso.pressBackUnconditionally()
            onView(withId(R.id.button)).check(matches(withText("Button")))
        }
    }
}
