package com.example.navigation.interaction.dialog

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import com.example.navigation.R
import com.google.common.truth.Truth
import org.hamcrest.Matchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationDialogInteractionActivityTest {

    @Test
    fun testNavigationDialogInteractionActivity() {
        val scenario = launchActivity<NavigationDialogInteractionActivity>()
        onView(
            allOf(
                withText("Dialog Interaction Home"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())

        onView(
            allOf(
                withText("Dialog Interaction Details"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.set)).check(matches(isDisplayed()))
        onView(withId(R.id.set)).perform(click())

        pressBackUnconditionally()
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Hello")))
        pressBackUnconditionally()
        onView(
            allOf(
                withText("Dialog Interaction Home"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        pressBackUnconditionally()
        Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }

    @Test
    fun testRotateNavigationDialogInteractionActivity() {
        val scenario = launchActivity<NavigationDialogInteractionActivity>()
        onView(
            allOf(
                withText("Dialog Interaction Home"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())

        onView(
            allOf(
                withText("Dialog Interaction Details"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.set)).check(matches(isDisplayed()))
        onView(withId(R.id.set)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(ViewAssertions.doesNotExist())

        // Recreate or make config change
        scenario.recreate()

        val instrumentation = getInstrumentation()
        val uiDevice = UiDevice.getInstance(instrumentation)
        val context: Context = ApplicationProvider.getApplicationContext()
        uiDevice.waitForWindowUpdate(context.packageName, 1000)

        pressBackUnconditionally()
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Hello")))
        pressBackUnconditionally()
        onView(
            allOf(
                withText("Dialog Interaction Home"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        pressBackUnconditionally()
        Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
