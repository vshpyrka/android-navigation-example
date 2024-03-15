plugins {
    alias(pluginLibs.plugins.android.library)
    alias(pluginLibs.plugins.kotlin.android)
    alias(pluginLibs.plugins.kotlin.kapt)
    alias(pluginLibs.plugins.navigation.safeargs)
}

android {
    namespace = "com.example.navigation"
    compileSdk = sdk.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = sdk.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(project(":navigation-feature-info"))
    implementation(project(":navigation-feature-settings"))

    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)
    implementation(libs.material)

    // Looks like this library is used also in tests, not sure which exact
    // library is missing that pulls that tracing lib
    implementation(libs.tracing)

    implementation(libs.glide)
    kapt(libs.glide.compiler)

    debugImplementation(testLibs.fragment.testing.manifest)
    androidTestImplementation(testLibs.fragment.testing)
    androidTestImplementation(testLibs.navigation.testing)
    androidTestImplementation(testLibs.core.ktx)
    androidTestImplementation(testLibs.espresso)
    androidTestImplementation(testLibs.espresso.device)
    androidTestImplementation(testLibs.android.junit.ktx)
    androidTestImplementation(testLibs.espresso.contrib) {
        exclude(group = "org.checkerframework", module = "checker")
        exclude(module = "protobuf-lite")
    }
    androidTestImplementation(testLibs.espresso.intents)
    androidTestImplementation(testLibs.test.runner)
    androidTestImplementation(testLibs.test.rules)
    androidTestImplementation(testLibs.uiautomator)
    androidTestImplementation(testLibs.truth)

    implementation("com.google.guava:guava:32.0.1-jre")
    implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")
}
