plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {

    namespace = "com.example.navigationfeaturelist"

    compileSdk = sdk.versions.compileSdk.get().toInt()

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        minSdk = sdk.versions.minSdk.get().toInt()
        targetSdk = sdk.versions.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)

    testImplementation(testLibs.junit)
    androidTestImplementation(testLibs.android.junit)
    androidTestImplementation(testLibs.espresso)
}
