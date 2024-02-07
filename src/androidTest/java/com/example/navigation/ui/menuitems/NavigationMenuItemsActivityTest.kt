package com.example.navigation.ui.menuitems

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.withToolbarTitle
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationMenuItemsActivityTest {

    @Test
    fun testNavigationMenuItemsActivity() {
        val scenario = launchActivity<NavigationMenuItemsActivity>()
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Navigation MenuItem")))
        onView(withId(R.id.navigationMenuItemFragmentTwo)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("MenuItem Destination")))
        onView(ViewMatchers.withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Navigation MenuItem")))
        Espresso.pressBackUnconditionally()
        assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
