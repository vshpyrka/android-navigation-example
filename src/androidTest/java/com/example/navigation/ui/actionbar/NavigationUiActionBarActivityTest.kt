package com.example.navigation.ui.actionbar

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth
import org.hamcrest.Matchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiActionBarActivityTest {

    @Test
    fun testNavigationUiActionBarActivity() {
        val activityScenario = launchActivity<NavigationUiActionBarActivity>()

        onView(
            allOf(
                withText("ActionBar Navigation"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())
        onView(
            allOf(
                withText("ActionBar Navigation Destination"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(
            withContentDescription(
                androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description
            )
        ).perform(
            click()
        )
        onView(
            allOf(
                withText("ActionBar Navigation"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        pressBackUnconditionally()
        Truth.assertThat(activityScenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        activityScenario.close()
    }
}
