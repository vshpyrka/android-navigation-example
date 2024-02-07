package com.example.navigation.deeplinks.explicit

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.os.bundleOf
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import com.example.navigation.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationExplicitDeepLinkActivityTest {

    @get:Rule
    @JvmField
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(Manifest.permission.POST_NOTIFICATIONS)

    @Before
    fun setUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Sometimes it can't find grantRuntimePermission method in framework.jar file
            val permission = Manifest.permission.POST_NOTIFICATIONS
            InstrumentationRegistry.getInstrumentation().uiAutomation.grantRuntimePermission(
                InstrumentationRegistry.getInstrumentation().targetContext.packageName,
                permission
            )
        }
    }

    @Test
    fun testLaunchExplicitDeepLinkActivity() {
        val context: Context = ApplicationProvider.getApplicationContext()
        launchActivity<NavigationExplicitDeepLinkActivity>(
            Intent(context, NavigationExplicitDeepLinkActivity::class.java).apply {
                putExtras(
                    bundleOf(
                        NavigationExplicitDeepLinkActivity.KEY_FIRST to "key",
                        NavigationExplicitDeepLinkActivity.KEY_SECOND to 123,
                        NavigationExplicitDeepLinkActivity.KEY_THIRD to 982
                    )
                )
            }
        )
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val uiDevice = UiDevice.getInstance(instrumentation)
        uiDevice.openNotification()

        val expectedAppName = "Android Playground"

        uiDevice.wait(Until.hasObject(By.textStartsWith(expectedAppName)), 2000)

        val description: UiObject2 = uiDevice.findObject(By.textStartsWith("Explicit NavGraph DeepLink"))
        description.click()

        // Wait until app becomes visible again
        // uiDevice.wait(Until.hasObject(By.pkg(context.packageName).depth(0)), 2000)
        uiDevice.waitForWindowUpdate(context.packageName, 1000)
        onView(withId(R.id.text)).check(matches(withText("Received Deeplink Arguments: \nid=982 \nstatus=123")))
        Espresso.pressBackUnconditionally()
        onView(withId(R.id.title)).check(matches(withText("Nested Nav DeepLink Home")))
        Espresso.pressBackUnconditionally()
        onView(withId(R.id.title)).check(matches(withText("Explicit DeepLink Home")))
    }
}
