package com.example.navigation.utils

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import androidx.annotation.IntRange
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import com.example.navigation.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.StringDescription
import java.util.concurrent.Callable
import java.util.concurrent.TimeoutException

fun withBottomNavViewCheckedItem(id: Int): Matcher<View> {
    return object : BoundedMatcher<View, BottomNavigationView>(BottomNavigationView::class.java) {

        override fun matchesSafely(bottomNavigationView: BottomNavigationView): Boolean {
            return bottomNavigationView.menu.findItem(id)?.isChecked ?: false
        }

        override fun describeTo(description: Description) {
            description.appendText("Menu item is checked")
        }
    }
}

fun <T : Activity> ActivityScenario<T>.getToolbarNavigationContentDescription(): String {
    var description = ""
    onActivity {
        description =
            it.findViewById<Toolbar>(R.id.toolbar).navigationContentDescription as String
    }
    return description
}

fun <T : Fragment> FragmentScenario<T>.getToolbarNavigationContentDescription(): String {
    var description = ""
    onFragment {
        description =
            it.requireView()
                .findViewById<Toolbar>(R.id.toolbar).navigationContentDescription as String
    }
    return description
}

fun withToolbarTitle(title: CharSequence) =
    object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {

        override fun matchesSafely(item: Toolbar): Boolean {
            return item.title.toString() == title
        }

        override fun describeTo(description: Description) {
            with(description) {
                appendText("with toolbar title: ")
                appendValue(title)
            }
        }
    }

fun withToolbarTitle(@StringRes titleId: Int) =
    object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {

        override fun matchesSafely(item: Toolbar): Boolean {
            val titleText = item.context.getString(titleId)
            return item.title.toString() == titleText
        }

        override fun describeTo(description: Description) {
            with(description) {
                appendText("with collapsing toolbar title ID: ")
                appendValue(titleId)
            }
        }

        override fun describeMismatch(item: Any, description: Description) {
            super.describeMismatch(item, description)
            item as Toolbar
            val titleResName = item.context.resources.getResourceName(titleId)
            val titleText = item.context.getString(titleId)
            with(description) {
                appendText("with collapsing toolbar title ID: ")
                appendValue(titleResName)
                appendText("resolved as: ")
                appendValue(titleText)
                appendText("and actual title: ")
                appendValue(item.title)
            }
        }
    }

fun withCollapsingToolbarTitle(title: CharSequence) =
    object : BoundedMatcher<Any, CollapsingToolbarLayout>(CollapsingToolbarLayout::class.java) {

        override fun matchesSafely(item: CollapsingToolbarLayout): Boolean {
            return item.title.toString() == title
        }

        override fun describeTo(description: Description) {
            with(description) {
                appendText("with collapsing toolbar title: ")
                appendValue(title)
            }
        }
    }

fun withCollapsingToolbarTitle(@StringRes titleId: Int) =
    object : BoundedMatcher<Any, CollapsingToolbarLayout>(CollapsingToolbarLayout::class.java) {

        override fun matchesSafely(view: CollapsingToolbarLayout): Boolean {
            val titleText = view.context.getString(titleId)
            return view.title.toString() == titleText
        }

        override fun describeTo(description: Description) {
            with(description) {
                appendText("with collapsing toolbar title ID: ")
                appendValue(titleId)
            }
        }

        override fun describeMismatch(item: Any, description: Description) {
            super.describeMismatch(item, description)
            item as CollapsingToolbarLayout
            val titleResName = item.context.resources.getResourceName(titleId)
            val titleText = item.context.getString(titleId)
            with(description) {
                appendText("with collapsing toolbar title ID: ")
                appendValue(titleResName)
                appendText("resolved as: ")
                appendValue(titleText)
                appendText("and actual title: ")
                appendValue(item.title)
            }
        }
    }

/**
 * Waits for the given `condition` to return `true`.
 * If the timeout elapses before the condition returns `true`, this method throws an exception.
 * @param reason    Reason printed when waiting for condition timeouts.
 * @param condition Condition to wait for.
 * @param timeout   Timeout in ms.
 */
fun waitForCondition(reason: String, condition: Callable<Boolean>, @IntRange(from = 0) timeout: Long) {
    val end = System.currentTimeMillis() + timeout

    try {
        while (!condition.call()) {
            if (System.currentTimeMillis() > end) {
                throw AssertionError(reason)
            }

            Thread.sleep(16)
        }
    } catch (e: Exception) {
        throw e
    }
}

fun waitForView(viewMatcher: Matcher<View>, timeout: Long = 10000, waitForDisplayed: Boolean = true): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return Matchers.any(View::class.java)
        }

        override fun getDescription(): String {
            val matcherDescription = StringDescription()
            viewMatcher.describeTo(matcherDescription)
            return "wait for a specific view <$matcherDescription> to be ${if (waitForDisplayed) "displayed" else "not displayed during $timeout millis."}"
        }

        override fun perform(uiController: UiController, view: View) {
            uiController.loopMainThreadUntilIdle()
            val startTime = System.currentTimeMillis()
            val endTime = startTime + timeout
            val visibleMatcher = isDisplayed()

            do {
                val viewVisible = TreeIterables.breadthFirstViewTraversal(view)
                    .any { viewMatcher.matches(it) && visibleMatcher.matches(it) }

                if (viewVisible == waitForDisplayed) return
                uiController.loopMainThreadForAtLeast(50)
            } while (System.currentTimeMillis() < endTime)

            // Timeout happens.
            throw PerformException.Builder()
                .withActionDescription(this.description)
                .withViewDescription(HumanReadables.describe(view))
                .withCause(TimeoutException())
                .build()
        }
    }
}
