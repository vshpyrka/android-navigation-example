package com.example.navigation.args

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import junit.framework.AssertionFailedError
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArgumentPassActivityTest {

    private lateinit var scenario: ActivityScenario<ArgumentPassActivity>

    @Before
    fun setUp() {
        scenario = launchActivity()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testArgumentPassActivity() {
        onView(withId(R.id.text)).check(matches(withText("Hello World!")))
    }

    @Test(expected = AssertionFailedError::class)
    fun testArgumentPassActivityFail() {
        onView(withId(R.id.text)).check(matches(withText("test")))
    }
}
