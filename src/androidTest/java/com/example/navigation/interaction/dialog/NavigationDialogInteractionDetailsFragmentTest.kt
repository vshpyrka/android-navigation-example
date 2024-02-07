package com.example.navigation.interaction.dialog

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationDialogInteractionDetailsFragmentTest {

    @Test
    fun testNavigationDialogInteractionFragmentTwo() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragmentInContainer {
            NavigationDialogInteractionDetailsFragment().also {
                it.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        navController.setGraph(R.navigation.activity_dialog_interaction_nav_graph)
                        Navigation.setViewNavController(it.requireView(), navController)
                        navController.navigate(R.id.navigationDialogInteractionFragmentTwo)
                    }
                }
            }
        }
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        scenario.close()
    }
}
