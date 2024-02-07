package com.example.navigation.destinations

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DestinationsActivityTest {

    @Test
    fun testDestinations() {
        val scenario = launchActivity<DestinationsActivity>()

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.button)).check(matches(withText("Back")))

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.button)).check(matches(withText("Hello blank fragment")))

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.button)).perform(click())

        Espresso.pressBackUnconditionally()
        assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
