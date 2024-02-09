# android-navigation-example

Set of examples of Jetpack Navigation Component usage.

[NavigationIncludedGraphActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/included/NavigationIncludedGraphActivity.kt) - Shows example of how to use nested graph as included file

Example:
```
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_second_nav_graph"
    app:startDestination="@id/secondNavigationFragmentOne">

    <fragment
        android:id="@+id/secondNavigationFragmentOne"
        android:name="com.example.navigation.included.SecondNavigationFragmentOne"
        android:label="fragment_second_navigation_one"
        tools:layout="@layout/fragment_second_navigation_one">
        <action
            android:id="@+id/action_secondNavigationFragmentOne_to_navigation"
            app:destination="@id/activity_second_included_graph" />
    </fragment>

    <include app:graph="@navigation/activity_second_included_graph" />
</navigation>

```
[DestinationsActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/destinations/DestinationsActivity.kt) - Shows example of how to navigate to a destination and perform backward navigation using destination action navigation call with `app:popUpTo` and `app:popUpToInclusive` tags

Example:

https://github.com/vshpyrka/android-navigation-example/assets/2741602/09246f06-9936-49cd-a548-ce573179b13a

```
 <fragment
        android:id="@+id/destinationFragmentTwo"
        android:name="com.example.navigation.destinations.DestinationFragmentTwo"
        android:label="fragment_destination_two"
        tools:layout="@layout/fragment_destination_two">

        <action
            android:id="@+id/action_destinationFragmentTwo_to_destinationFragmentOne"
            app:destination="@id/destinationFragmentOne"
            app:enterAnim="@anim/nav_default_enter_anim"
            app:exitAnim="@anim/nav_default_exit_anim"
            app:popEnterAnim="@anim/nav_default_pop_enter_anim"
            app:popExitAnim="@anim/nav_default_pop_exit_anim"
            app:popUpTo="@+id/destinationFragmentOne"
            app:popUpToInclusive="true" />
    </fragment>
```

[BrowsableActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/deeplinks/BrowsableActivity.kt) - Shows example of how to open activity by launching a specific deep link

https://github.com/vshpyrka/android-navigation-example/assets/2741602/50e521e9-40cf-450b-8310-aa8862c9092f

AndroidManifest.xml configuration
```
<activity
    android:name="com.example.navigation.deeplinks.BrowsableActivity"
    android:exported="true"
    android:launchMode="singleTask">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />

        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <!-- Accepts URIs that begin with "http://www.example.com/gizmos” -->
        <data
            android:host="www.example.com"
            android:pathPrefix="/gizmos"
            android:scheme="http" />
        <!-- note that the leading "/" is required for pathPrefix -->
    </intent-filter>
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />

        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <!-- Accepts URIs that begin with "example://gizmos” -->
        <data
            android:host="gizmos"
            android:scheme="example" />
    </intent-filter>
</activity>
```

Intent can be sent from the command line by one of examples:

adb shell am start \
-W -a android.intent.action.VIEW \
-d "example://gizmos" com.example.myapplication

adb shell am start \
-W -a android.intent.action.VIEW \
-d "http://www.example.com/gizmos?status=200"

[NavigationExplicitDeepLinkActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/deeplinks/explicit/NavigationExplicitDeepLinkActivity.kt) - Shows the example of how to launch explicit activity and pass information using [NavDeepLinkBuilder](https://developer.android.com/reference/androidx/navigation/NavDeepLinkBuilder) class. 

https://github.com/vshpyrka/android-navigation-example/assets/2741602/b6e31f5e-dc1f-45c4-b686-9f79eef6dbd7

[ArgumentsActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/args/ArgumentsActivity.kt) - Shows example of how to set and pass direct fragment arguments and example of how to overwrite argument with different default value in navigation destination action.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/007ab25b-5ab2-400c-ab5f-a4cde220dc48

```
<fragment
        android:id="@+id/argumentFragmentOne"
        android:name="com.example.navigation.args.ArgumentFragmentOne"
        tools:layout="@layout/fragment_argument_one" >
        <action
            android:id="@+id/action_destinationFragmentOne_to_destinationFragmentTwo"
            app:destination="@id/argumentFragmentTwo">
            <argument
                android:name="argument"
                android:defaultValue="200"
                app:argType="integer" />
        </action>
    </fragment>

    <fragment
        android:id="@+id/argumentFragmentTwo"
        android:name="com.example.navigation.args.ArgumentFragmentTwo"
        tools:layout="@layout/fragment_argument_two">
        <argument
            android:name="argument"
            android:defaultValue="100"
            app:argType="integer" />
```
[ArgumentPassActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/args/ArgumentPassActivity.kt) - Shows example of how to pass argument to Activity graph first destination.

[NavAnimActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/anim/NavAnimActivity.kt) - Shows example of how to make shared element fragment transition using Jetpack Navigation Component.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/620da395-487d-4699-b2f4-145e6c9af81b




