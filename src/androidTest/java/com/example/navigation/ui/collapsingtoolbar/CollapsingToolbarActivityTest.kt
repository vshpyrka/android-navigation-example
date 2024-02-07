package com.example.navigation.ui.collapsingtoolbar

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.getToolbarNavigationContentDescription
import com.example.navigation.utils.withCollapsingToolbarTitle
import com.example.navigation.R
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CollapsingToolbarActivityTest {

    @Test
    fun testCollapsingToolbarActivity() {
        val activityScenario = launchActivity<CollapsingToolbarActivity>()

        val toolBarDescription = withContentDescription(
            activityScenario.getToolbarNavigationContentDescription()
        )

        onView(toolBarDescription).check(matches(isDisplayed()))
        onView(withId(R.id.collapsing_toolbar_layout)).check(matches(withCollapsingToolbarTitle("Collapsing Toolbar Navigation")))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.collapsing_toolbar_layout)).check(matches(withCollapsingToolbarTitle("Destination")))
        onView(toolBarDescription).perform(click())
        onView(withId(R.id.collapsing_toolbar_layout)).check(matches(withCollapsingToolbarTitle("Collapsing Toolbar Navigation")))

        pressBackUnconditionally()
        Truth.assertThat(activityScenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        activityScenario.close()
    }
}
