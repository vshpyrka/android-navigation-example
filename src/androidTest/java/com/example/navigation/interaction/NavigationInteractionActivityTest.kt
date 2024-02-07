package com.example.navigation.interaction

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.example.navigation.interaction.dialog.NavigationDialogInteractionActivity
import com.example.navigation.interaction.dynamicnavhost.DynamicNavHostActivity
import com.example.navigation.interaction.modifygraph.NavigationModifyNavGraphActivity
import com.example.navigation.interaction.navgraphviewmodel.NavigationNavGraphViewModelActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationInteractionActivityTest {

    private lateinit var scenario: ActivityScenario<NavigationInteractionActivity>

    @Before
    fun setUp() {
        scenario = launchActivity()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
        scenario.close()
    }

    @Test
    fun testOpenDynamicNavHost() {
        onView(withId(R.id.dynamicNavHost)).perform(click())
        intended(hasComponent(DynamicNavHostActivity::class.java.name))
    }

    @Test
    fun testOpenDialogDestination() {
        onView(withId(R.id.dialogDestination)).perform(click())
        intended(hasComponent(NavigationDialogInteractionActivity::class.java.name))
    }

    @Test
    fun testOpenNavGraphViewModel() {
        onView(withId(R.id.navGraphViewModel)).perform(click())
        intended(hasComponent(NavigationNavGraphViewModelActivity::class.java.name))
    }

    @Test
    fun testOpenModifyNavGraph() {
        onView(withId(R.id.modifyNavGraph)).perform(click())
        intended(hasComponent(NavigationModifyNavGraphActivity::class.java.name))
    }

}
