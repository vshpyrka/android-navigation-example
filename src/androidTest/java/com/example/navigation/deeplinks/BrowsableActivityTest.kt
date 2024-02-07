package com.example.navigation.deeplinks

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigation.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BrowsableActivityTest {

    @Test
    fun testDeepLinkUri() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val intent =
            Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com/gizmos?status=200"))
                .setPackage(context.packageName)
        val scenario = launchActivity<BrowsableActivity>(intent)
        onView(withId(R.id.text)).check(matches(withText("action=android.intent.action.VIEW, \ndata=http://www.example.com/gizmos?status=200, \ncode=200")))
        scenario.close()
    }
}
