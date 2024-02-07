package com.example.navigation.included

import androidx.test.core.app.launchActivity
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
class NavigationIncludedGraphActivityTest {

    @Test
    fun testIncludedGraph() {
        val scenario = launchActivity<NavigationIncludedGraphActivity>()
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.text)).check(matches(withText("Included graph fragment")))
        scenario.close()
    }
}
