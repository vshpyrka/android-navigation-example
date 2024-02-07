package com.example.navigation.ui.appbarvariations

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationUiAppBarVariationFragmentOneTest {

    @Test
    fun testNavigationUiAppBarVariationFragmentOne() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario =
            launchFragmentInContainer(themeResId = R.style.AppTheme) {
                NavigationUiAppBarVariationFragmentOne().also {
                    it.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                        if (viewLifecycleOwner != null) {
                            navController.setGraph(R.navigation.activity_navigation_app_bar_variation_nav_graph)
                            Navigation.setViewNavController(it.requireView(), navController)
                        }
                    }
                }
            }
        onView(withId(R.id.button)).perform(click())
        assertThat(navController.currentDestination?.id)
            .isEqualTo(R.id.navigationUiAppBarVariationFragmentTwo)
        scenario.close()
    }
}
