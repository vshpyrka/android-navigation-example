# android-navigation-example

Set of examples of Jetpack Navigation Component usage.

* [NavigationIncludedGraphActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/included/NavigationIncludedGraphActivity.kt) - Shows example of how to use nested graph as included file

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
* [DestinationsActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/destinations/DestinationsActivity.kt) - Shows example of how to navigate to a destination and perform backward navigation using destination action navigation call with `app:popUpTo` and `app:popUpToInclusive` tags

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

* [BrowsableActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/deeplinks/BrowsableActivity.kt) - Shows example of how to open activity by launching a specific deep link

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

* [NavigationExplicitDeepLinkActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/deeplinks/explicit/NavigationExplicitDeepLinkActivity.kt) - Shows the example of how to launch explicit activity and pass information using [NavDeepLinkBuilder](https://developer.android.com/reference/androidx/navigation/NavDeepLinkBuilder) class. 

https://github.com/vshpyrka/android-navigation-example/assets/2741602/b6e31f5e-dc1f-45c4-b686-9f79eef6dbd7

* [ArgumentsActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/args/ArgumentsActivity.kt) - Shows example of how to set and pass direct fragment arguments and example of how to overwrite argument with different default value in navigation destination action.

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
* [ArgumentPassActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/args/ArgumentPassActivity.kt) - Shows example of how to pass argument to Activity graph first destination.
Example:
```
    val navHostFragment = binding.container.getFragment<NavHostFragment>()
    navHostFragment.findNavController().apply {
        setGraph(
            R.navigation.activity_argument_pass_nav_graph,
            bundleOf("key" to "Hello World!")
        )
    }
```

* [NavAnimActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/anim/NavAnimActivity.kt) - Shows example of how to make shared element fragment transition using Jetpack Navigation Component using `FragmentNavigatorExtras` and `sharedElementEnterTransition`

https://github.com/vshpyrka/android-navigation-example/assets/2741602/620da395-487d-4699-b2f4-145e6c9af81b

* [NavigationUiActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/NavigationUiActivity.kt) - Contains set of examples for integration of Jetpack Navigation Component with UI components.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/fbbde8ac-5b57-4167-b957-078dc6d4f534

* [NavigationUiToolbarActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/toolbar/NavigationUiToolbarActivity.kt) - Shows how to combine Toolbar, NavController with AppBarConfiguration to make Toolbar react to navigation changes and display current visible Fragment title.
```
    val navController = navHostFragment.findNavController()
    // Add Back button which navigates to parent activity specified in manifest
    val appBarConfiguration = AppBarConfiguration(
        topLevelDestinationIds = setOf(),
        fallbackOnNavigateUpListener = ::onSupportNavigateUp
    )
    binding.toolbar.setupWithNavController(navController, appBarConfiguration)
```
* [CollapsingToolbarActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/collapsingtoolbar/CollapsingToolbarActivity.kt) - Shows example of how to use CollapsingToolbar component with NavController with AppBarConfiguration instance.
* [NavigationUiActionBarActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/actionbar/NavigationUiActionBarActivity.kt) - Shows example of how to use standard Activity ActionBar and bind it with NavController for appropriate navigation with overriden `onSupportNavigateUp()` activity method.
```
    val navController = navHostFragment.findNavController()
    appBarConfiguration = AppBarConfiguration(navController.graph)
    setupActionBarWithNavController(navController, appBarConfiguration)
    
...

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.content)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
```
* [NavigationUiAppBarVariationActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/appbarvariations/NavigationUiAppBarVariationActivity.kt) - Shows example of how to use own Toolbars inside of separate fragments of navigation graph.
* [NavigationMenuItemsActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/menuitems/NavigationMenuItemsActivity.kt) - Shows example of how to use Toolbar Menu and combine it with NavController instance to make navigation on MenuItem click.
```
    val navHostFragment = binding.container.getFragment<NavHostFragment>()
    val navController = navHostFragment.findNavController()
    
    val appBarConfiguration = AppBarConfiguration(navController.graph)
    toolBar.setupWithNavController(navController, appBarConfiguration)
    
    toolBar.inflateMenu(R.menu.menu_navigation_items)
    
    toolBar.setOnMenuItemClickListener {
        it.onNavDestinationSelected(findNavController(R.id.container))
    }
```
* [NavigationDrawerActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/drawer/NavigationDrawerActivity.kt) - Shows example of how to use DrawerLayout with NavigationView and combine navigation with NavController
NavController setup:
```
    val navHostFragment = binding.container.getFragment<NavHostFragment>()
    val navController = navHostFragment.findNavController()
    
    val appBarConfiguration = AppBarConfiguration(
        setOf(
            R.id.home,
            R.id.info,
            R.id.settings
        ),
        binding.drawerLayout
    )
    binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    binding.navView.setupWithNavController(navController)
```
NavGraph contains several root destinations which are opened from DrawerLayout menu, one external destination which is opened from the root menu item destination, and separate nested graph which acts as a separate DrawerLayout menu item:
```
    <?xml version="1.0" encoding="utf-8"?>
    <navigation xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/activity_navigation_drawer_nav_graph"
        app:startDestination="@id/home">
    
        <fragment
            android:id="@+id/home"
            android:name="com.example.navigation.ui.drawer.NavigationDrawerHomeFragment"
            android:label="Home"
            tools:layout="@layout/fragment_navigation_drawer_home" />
        <fragment
            android:id="@+id/info"
            android:name="com.example.navigation.ui.drawer.NavigationDrawerInfoFragment"
            android:label="Info"
            tools:layout="@layout/fragment_navigation_drawer_info">
            <action
                android:id="@+id/action_navigationDrawerInfoFragment_to_navigationDrawerFragmentOuter"
                app:destination="@id/navigationDrawerFragmentOuter" />
        </fragment>
        <fragment
            android:id="@+id/navigationDrawerFragmentOuter"
            android:name="com.example.navigation.ui.drawer.NavigationDrawerFragmentOuter"
            android:label="Outer Root Fragment"
            tools:layout="@layout/fragment_navigation_drawer_outer" />
    
        <include app:graph="@navigation/activity_navigation_drawer_nested_nav_graph" />
    </navigation>

```
* [NavigationUiBottomNavActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/bottomnav/NavigationUiBottomNavActivity.kt) - Shows example of how to use NavController with BottomNavigationView component with own navigation graphs inside of each page.
Graph example:
```
    <?xml version="1.0" encoding="utf-8"?>
    <navigation xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/activity_navigation_bottom_nav"
        app:startDestination="@id/info">
    
        <include app:graph="@navigation/activity_navigation_bottom_nav_info_graph" />
        <include app:graph="@navigation/activity_navigation_bottom_nav_settings_graph" />
    
    </navigation>
```
* [NavigationUiDestinationListenerActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/ui/destination/NavigationUiDestinationListenerActivity.kt) - Shows example of how to listen for destination changes and alter UI respectively. Example shows when the app navigates to the next destination FloatingActionButton is automatically hidden.
* [NavigationDSLActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/dsl/NavigationDSLActivity.kt) - Shows example of how to build and provide dynamic navigation graph using Navigation DSL

https://github.com/vshpyrka/android-navigation-example/assets/2741602/82721fe0-a42a-4ed0-9f21-1e7d6d6ef439

Example:
```
    val navHostFragment =
    supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
    
    navHostFragment.navController.apply {
    graph = createGraph(
        nav_graph.id,
        nav_graph.dest.home
    ) {
        fragment<NavigationDSLFragmentOne>(nav_graph.dest.home) {
            label = "Home"
            action(nav_graph.action.to_detail) {
                destinationId = nav_graph.id
            }
        }
        fragment<NavigationDSLFragmentTwo>(nav_graph.dest.detail) {
            label = "Details"
            argument(nav_graph.args.id) {
                type = NavType.StringType
                nullable = false
                defaultValue = "defaultValue"
            }
        }
    
        // Activity Destination
        activity(nav_graph.dest.activity) {
            activityClass = NavigationDSLActivityDestination::class
        }
``` 
* [DynamicNavHostActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/interaction/dynamicnavhost/DynamicNavHostActivity.kt) - Shows example of how to create `NavHostFragment` dynamically and set it to a FrameLayout.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/42b8f060-7746-4a24-81e3-7370ad3e3a17

Example:
```
    // Dynamic NavHost doesn't restore state when config change or app killed
    val navHost =
        NavHostFragment.create(R.navigation.activity_navigation_dynamic_nav_host_nav_graph)
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, navHost)
        .setPrimaryNavigationFragment(navHost)
        .commitNow()
    
    val navController = navHost.navController
```

*[NavigationDialogInteractionActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/interaction/dialog/NavigationDialogInteractionActivity.kt) - Shows example of navigation interaction with `DialogFragment`.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/8a63f1ca-7ef8-4132-8062-848ba2165cb4

The value from DialogFragmnet is set via `previousBackStackEntry.savedStateHandle` instance. 

On the observer side the fragment has to get the instance of current backstack entry by current navigation destination id `navController.getBackStackEntry(R.id.currentFragment)`.
Then subscribe to the lifecycle event to receive data from current backstack entry SavedStateHandle instance:
```
    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_RESUME && backStackEntry.savedStateHandle.contains("key")) {
            val result = backStackEntry.savedStateHandle.get<String>("key")
            ...
    }
    backStackEntry.lifecycle.addObserver(observer)
```
* [NavigationNavGraphViewModelActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/interaction/navgraphviewmodel/NavigationNavGraphViewModelActivity.kt) - Shows example of how to scope `ViewModel` instance to a navigation graph.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/aac89af6-3a8d-43c7-b202-dda6e9e4e600

Two fragments are using a ViewModel instance that is shared and scoped to a navigation graph:
```
    // Retrieve viewModel instance scoped to nav graph
    private val viewModel by navGraphViewModels<GraphViewModel>(
        R.id.activity_navigation_nav_graph_viewmodel_nav_graph
    )
```
* [NavigationModifyNavGraphActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/interaction/modifygraph/NavigationModifyNavGraphActivity.kt) - Shows example of how to change navigation graph dynamically and change for instance start destination of that graph.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/ac6a35b0-2fa7-48ac-be91-3d8de6831b13

Example:
```
    val navHost = binding.container.getFragment<NavHostFragment>()
    val navController = navHost.findNavController()
    val navGraph =
        navController.navInflater.inflate(R.navigation.activity_navigation_modify_runtime_nav_graph)
    navGraph.setStartDestination(R.id.settings)
    // Always will navigate back to start destination
    navController.graph = navGraph
```
* [FeatureModuleNavigationActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/modules/FeatureModuleNavigationActivity.kt) - Shows example of how to use `BottomNavigationView` component which has separate navigation graphs for each menu item which are placed in separate modules.

https://github.com/vshpyrka/android-navigation-example/assets/2741602/c6b1e0bc-fdc7-4af6-a782-0ff52e52e762

Example:
```
    <?xml version="1.0" encoding="utf-8"?>
    <navigation xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/nav_graph"
        app:startDestination="@id/info_screen">
    
        <include app:graph="@navigation/module_info_nav_graph" />
        <include app:graph="@navigation/module_settings_nav_graph" />
    
    </navigation>
```
Example also shows how to make navigation from one module to a destination from another module using app deeplink
```
    binding.button.setOnClickListener {
        val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://com.example.navigation/settings_fragment_two".toUri())
            .build()
        findNavController().navigate(request)
    }
```
Fragment configuration which receives specified deeplink
```
    <fragment
        android:id="@+id/destination_from_another_module"
        android:name="NavigationFeatureModuleSettingsDetailsFragment">
        <deepLink app:uri="android-app://com.example.navigation/settings_fragment_two" />
    </fragment>
```

* [NavigationLaunchSingleTopActivity.kt](https://github.com/vshpyrka/android-navigation-example/blob/main/src/main/java/com/example/navigation/launchsingletop/NavigationLaunchSingleTopActivity.kt) - Shows example of how to launch the same fragment multiple times as a single instance using `app:launchSingleTop="true"` navigation attribute.
  
https://github.com/vshpyrka/android-navigation-example/assets/2741602/a501e607-a91f-42db-b2cc-cba9f835cd21

Example:
```
    <fragment
        android:id="@+id/secondFragment"
        android:name="NavigationLaunchSingleTopFragment">
        <action
            android:id="@+id/action_navigationLaunchSingleTopFragmentTwo_self"
            app:launchSingleTop="true"
            app:destination="@id/navigationLaunchSingleTopFragmentTwo" />
    </fragment>
```
