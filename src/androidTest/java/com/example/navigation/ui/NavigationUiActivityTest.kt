package com.example.navigation.ui

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
import com.example.navigation.ui.actionbar.NavigationUiActionBarActivity
import com.example.navigation.ui.appbarvariations.NavigationUiAppBarVariationActivity
import com.example.navigation.ui.bottomnav.NavigationUiBottomNavActivity
import com.example.navigation.ui.collapsingtoolbar.CollapsingToolbarActivity
import com.example.navigation.ui.destination.NavigationUiDestinationListenerActivity
import com.example.navigation.ui.drawer.NavigationDrawerActivity
import com.example.navigation.ui.menuitems.NavigationMenuItemsActivity
import com.example.navigation.ui.toolbar.NavigationUiToolbarActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiActivityTest {

    private lateinit var scenario: ActivityScenario<NavigationUiActivity>

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
    fun testOpenToolBar() {
        onView(withId(R.id.toolbar)).perform(click())
        intended(hasComponent(NavigationUiToolbarActivity::class.java.name))
    }

    @Test
    fun testOpenCollapsingToolbar() {
        onView(withId(R.id.collapsing_toolbar)).perform(click())
        intended(hasComponent(CollapsingToolbarActivity::class.java.name))
    }

    @Test
    fun testOpenActionBar() {
        onView(withId(R.id.action_toolbar)).perform(click())
        intended(hasComponent(NavigationUiActionBarActivity::class.java.name))
    }

    @Test
    fun testOpenAppBarVariations() {
        onView(withId(R.id.app_bar_variations)).perform(click())
        intended(hasComponent(NavigationUiAppBarVariationActivity::class.java.name))
    }

    @Test
    fun testOpenMenuItems() {
        onView(withId(R.id.menu_items)).perform(click())
        intended(hasComponent(NavigationMenuItemsActivity::class.java.name))
    }

    @Test
    fun testOpenDrawer() {
        onView(withId(R.id.drawer)).perform(click())
        intended(hasComponent(NavigationDrawerActivity::class.java.name))
    }

    @Test
    fun testOpenBottomNav() {
        onView(withId(R.id.bottomNav)).perform(click())
        intended(hasComponent(NavigationUiBottomNavActivity::class.java.name))
    }

    @Test
    fun testOpenDestinationListener() {
        onView(withId(R.id.destination)).perform(click())
        intended(hasComponent(NavigationUiDestinationListenerActivity::class.java.name))
    }
}
