package com.example.navigation.interaction.dynamicnavhost

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelStore
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DynamicNavHostDetailsFragmentTest {

    @Test
    fun testDynamicNavHostFragmentTwo() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragmentInContainer<DynamicNavHostDetailsFragment>()
        scenario.onFragment {
            navController.setViewModelStore(ViewModelStore())
            navController.setGraph(R.navigation.activity_navigation_dynamic_nav_host_nav_graph)
            Navigation.setViewNavController(it.requireView(), navController)
            navController.navigate(R.id.dynamicNavHostDetailsFragment)
        }
        onView(withId(R.id.button)).perform(click())
        val prevBackStackEntry =
            navController.getBackStackEntry(R.id.dynamicNavHostHomeFragment)
        val value = prevBackStackEntry.savedStateHandle.get<String>("test")
        Assert.assertEquals("value", value)
        Truth.assertThat(navController.currentDestination?.id).isEqualTo(R.id.dynamicNavHostHomeFragment)
        scenario.close()
    }
}
