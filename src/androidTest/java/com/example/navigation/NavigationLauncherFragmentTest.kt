package com.example.navigation

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationLauncherFragmentTest {

    private lateinit var navController: NavController
    private lateinit var scenario: FragmentScenario<NavigationLauncherFragment>

    @Before
    fun setUp() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        scenario = launchFragmentInContainer(themeResId = R.style.AppTheme)
        scenario.onFragment {
            navController.setGraph(R.navigation.activity_navigation)
            Navigation.setViewNavController(it.requireView(), navController)
            navController.navigate(R.id.fragment_launcher)
        }
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testIncludedGraphNavigation() {
        onView(ViewMatchers.withId(R.id.included_graph))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.includedGraphNavigationActivity)
    }

    @Test
    fun testDestinationsNavigation() {
        onView(ViewMatchers.withId(R.id.destinations))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.destinationsActivity)
    }

    @Test
    fun testBrowsableNavigation() {
        onView(ViewMatchers.withId(R.id.browsable))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.browsableActivity)
    }

    @Test
    fun testExplicitDeepLinkNavigation() {
        onView(ViewMatchers.withId(R.id.explicit_deep_link))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navigationExplicitDeepLinkActivity)
    }

    @Test
    fun testArgumentsNavigation() {
        onView(ViewMatchers.withId(R.id.arguments))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.argumentsActivity)
    }

    @Test
    fun testAnimationNavigation() {
        onView(ViewMatchers.withId(R.id.animation))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navAnimActivity)
    }

    @Test
    fun testUiNavigation() {
        onView(ViewMatchers.withId(R.id.ui))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navigationUiActivity)
    }

    @Test
    fun testDSLNavigation() {
        onView(ViewMatchers.withId(R.id.dsl))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navigationDSLActivity)
    }

    @Test
    fun testInteractionNavigation() {
        onView(ViewMatchers.withId(R.id.interaction))
            .perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.interactionNavHostActivity)
    }

    @Test
    fun testModulesNavigation() {
        onView(ViewMatchers.withId(R.id.modules))
            .perform(scrollTo(), ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.featureModuleNavigationActivity)
    }

    @Test
    fun testLaunchSingleTopNavigation() {
        onView(ViewMatchers.withId(R.id.launch_single_top))
            .perform(scrollTo(), ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.navigationLaunchSingleTopActivity)
    }
}
