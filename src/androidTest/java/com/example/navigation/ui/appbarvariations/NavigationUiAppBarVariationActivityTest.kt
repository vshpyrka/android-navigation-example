package com.example.navigation.ui.appbarvariations

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.withToolbarTitle
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiAppBarVariationActivityTest {

    @Test
    fun testNavigationUiAppBarVariationActivity() {
        val scenario = launchActivity<NavigationUiAppBarVariationActivity>()
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("AppBar Variation")))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("AppBar Variation Destination")))
        onView(
            withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description)
        ).perform(click())
        pressBackUnconditionally()
        assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
