package com.example.navigation.ui.toolbar

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.getToolbarNavigationContentDescription
import com.example.navigation.utils.withToolbarTitle
import com.example.navigation.R
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiToolbarActivityTest {

    @Test
    fun testNavigationUiToolbarActivity() {
        val activityScenario = launchActivity<NavigationUiToolbarActivity>()

        val toolBarDescription = withContentDescription(
            activityScenario.getToolbarNavigationContentDescription()
        )

        onView(toolBarDescription).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("First Navigation Fragment")))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Second Navigation Fragment")))
        onView(toolBarDescription).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("First Navigation Fragment")))

        pressBackUnconditionally()
        Truth.assertThat(activityScenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        activityScenario.close()
    }
}
