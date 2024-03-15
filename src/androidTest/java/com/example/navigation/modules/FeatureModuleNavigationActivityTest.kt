package com.example.navigation.modules

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.utils.withBottomNavViewCheckedItem
import com.example.navigation.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FeatureModuleNavigationActivityTest {

    private lateinit var scenario: ActivityScenario<FeatureModuleNavigationActivity>

    @Before
    fun setUp() {
        scenario = launchActivity()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testInfoModules() {
        onView(withId(R.id.info_screen)).perform(click())
        onView(withId(R.id.title)).check(matches(withText("Module NavHost Info")))
        onView(withId(R.id.button)).check(matches(withText("OPEN DEEP SCREEN FROM SETTINGS")))
    }

    @Test
    fun testSettingsModules() {
        onView(withId(R.id.settings_screen)).perform(click())
        onView(withId(R.id.title)).check(matches(withText("Module NavHost Settings")))
    }

    @Test
    fun testInfoModuleSettingsDeepLinkClick() {
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.bottom_nav)).check(matches(withBottomNavViewCheckedItem(R.id.settings_screen)))
        onView(withId(R.id.title)).check(matches(withText("Module NavHost Settings Details")))
    }
}
