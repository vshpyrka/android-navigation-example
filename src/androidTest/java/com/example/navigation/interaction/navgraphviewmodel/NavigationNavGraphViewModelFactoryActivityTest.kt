package com.example.navigation.interaction.navgraphviewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import com.google.common.truth.Truth
import org.hamcrest.Matchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationNavGraphViewModelFactoryActivityTest {

    @Test
    fun testNavigationNavGraphViewModelActivity() {
        val scenario = launchActivity<NavigationNavGraphViewModelActivity>()
        onView(
            allOf(
                withText("fragment_navigation_nav_graph_view_model_one"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        )
            .check(matches(isDisplayed()))
        var viewModel: GraphViewModel? = null
        scenario.onActivity {
            val navController = Navigation.findNavController(it, R.id.container)
            val viewModelStoreOwner =
                navController.getViewModelStoreOwner(R.id.activity_navigation_nav_graph_viewmodel_nav_graph)
            viewModel = ViewModelProvider(viewModelStoreOwner)[GraphViewModel::class.java]
        }
        onView(withId(R.id.button)).perform(click())
        onView(
            allOf(
                withText("fragment_navigation_nav_graph_view_model_two"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        onView(withContentDescription(androidx.navigation.ui.R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        onView(
            allOf(
                withText("fragment_navigation_nav_graph_view_model_one"),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
        Truth.assertThat(viewModel?.parameter).isEqualTo("Hello!World")
        pressBackUnconditionally()
        Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        scenario.close()
    }
}
