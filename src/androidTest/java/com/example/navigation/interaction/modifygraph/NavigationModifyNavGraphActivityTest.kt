package com.example.navigation.interaction.modifygraph

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.withBottomNavViewCheckedItem
import com.example.navigation.R
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationModifyNavGraphActivityTest {

    @Test
    fun testNavigationModifyNavGraphActivity() {
        val scenario = launchActivity<NavigationModifyNavGraphActivity>()
        onView(withId(R.id.bottom_nav)).check(matches(withBottomNavViewCheckedItem(R.id.settings)))
        onView(withId(R.id.text)).check(matches(withText("SETTINGS")))
        onView(withId(R.id.info)).perform(click())
        onView(withId(R.id.bottom_nav)).check(matches(withBottomNavViewCheckedItem(R.id.info)))
        onView(withId(R.id.text)).check(matches(withText("INFO")))
        // Returns back to start destination
        pressBackUnconditionally()
        onView(withId(R.id.bottom_nav)).check(matches(withBottomNavViewCheckedItem(R.id.settings)))
        onView(withId(R.id.text)).check(matches(withText("SETTINGS")))
        pressBackUnconditionally()
        Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
