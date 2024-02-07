package com.example.navigation.interaction.dynamicnavhost

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth
import org.hamcrest.Matchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DynamicNavHostActivityTest {

    @Test
    fun testDynamicNavHostActivity() {
        val scenario = launchActivity<DynamicNavHostActivity>()
        onView(
            allOf(
                withText("dynamic_nav_host_one"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(
            allOf(
                withText("dynamic_nav_host_two"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(
            allOf(
                withText("dynamic_nav_host_one"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Hello")))
        pressBackUnconditionally()
        Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
