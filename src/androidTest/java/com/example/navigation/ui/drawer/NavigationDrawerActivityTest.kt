package com.example.navigation.ui.drawer

import android.view.Gravity
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.withToolbarTitle
import com.example.navigation.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationDrawerActivityTest {

    @Test
    fun testNavigationDrawerActivity() {
        val scenario = launchActivity<NavigationDrawerActivity>()

        val openDrawer = {
            onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.START))) // Left Drawer should be closed.
                .perform(open()) // Open Drawer
        }

        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Home")))

        openDrawer()
        onView(withId(R.id.home)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Home")))
        onView(withId(R.id.title)).check(matches(withText("Home")))

        openDrawer()
        onView(withId(R.id.info)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Info")))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(withText("OPEN SEPARATE DESTINATION")))

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Outer Root Fragment")))
        onView(withId(R.id.title)).check(matches(withText("Outer Root Fragment")))
        onView(withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description)).perform(click())

        openDrawer()
        onView(withId(R.id.settings_nav_graph)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Settings")))
        onView(withId(R.id.button)).check(matches(withText("OPEN NEXT FRAGMENT")))
        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Settings Details")))
        onView(withId(R.id.title)).check(matches(withText("Drawer Item Nested Graph. Settings Details.")))
        onView(withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Settings")))

        scenario.close()
    }
}
