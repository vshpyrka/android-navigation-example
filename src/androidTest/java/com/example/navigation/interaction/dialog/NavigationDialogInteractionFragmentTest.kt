package com.example.navigation.interaction.dialog

import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelStore
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationDialogInteractionFragmentTest {

    @Test
    fun testNavigationDialogInteractionFragment() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragmentInContainer {
            NavigationDialogInteractionFragment().also {
                it.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    it.viewModelStore
                    if (viewLifecycleOwner != null) {
                        navController.setViewModelStore(ViewModelStore())
                        navController.setGraph(R.navigation.activity_dialog_interaction_nav_graph)
                        Navigation.setViewNavController(it.requireView(), navController)
                        navController.navigate(R.id.navigationDialogInteractionFragment)
                    }
                }
            }
        }
        onView(withId(R.id.set)).perform(click())
        val prevBackStackEntry =
            navController.getBackStackEntry(R.id.navigationDialogInteractionFragmentOne)
        val value = prevBackStackEntry.savedStateHandle.get<String>("key")
        Assert.assertEquals("Hello", value)
        scenario.close()
    }

    @Test
    fun testDismissDialogFragment() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragment {
            NavigationDialogInteractionFragment().also {
                it.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        navController.setViewModelStore(ViewModelStore())
                        navController.setGraph(R.navigation.activity_dialog_interaction_nav_graph)
                        Navigation.setViewNavController(it.requireView(), navController)
                        navController.navigate(R.id.navigationDialogInteractionFragment)
                    }
                }
            }
        }

        scenario.onFragment { fragment ->
            assertThat(fragment.dialog).isNotNull()
            assertThat(fragment.requireDialog().isShowing).isTrue()
            fragment.dismiss()
            fragment.parentFragmentManager.executePendingTransactions()
            assertThat(fragment.dialog).isNull()
        }
        onView(withId(R.id.button)).check(doesNotExist())
        scenario.close()
    }
}
