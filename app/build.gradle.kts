plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.studies.eatnearby"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.studies.eatnearby"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":common:utils"))
    implementation(project(":location:data"))
    implementation(project(":location:domain"))
    implementation(project(":location:presentation"))
    implementation(project(":dashboard:presentation"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)



    //hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation(Deps.coreKtx) // Core KTX
    implementation(Deps.appcompat) // AppCompat
    implementation(Deps.material) // Material Design
    implementation(Deps.constraintLayout) // Constraint Layout

    testImplementation(Deps.junit) // JUnit
    androidTestImplementation(Deps.androidTestJUnit) // Android Test JUnit
    androidTestImplementation(Deps.espressoCore) // Espresso

    implementation(Deps.retrofit) // Retrofit
    implementation(Deps.gsonConverter) // Gson Converter
    implementation(Deps.okHttp) // OkHttp
    implementation(Deps.scalarConverter) // Scalar Converter

    implementation(Deps.coroutinesCore) // Kotlin Coroutines Core
    implementation(Deps.lifecycleRuntimeKtx) // Lifecycle Runtime KTX
    implementation(Deps.glide) // Glide

    implementation(Deps.activityCompose) // Activity Compose
    implementation(Deps.composeUi) // Compose UI
    implementation(Deps.composeMaterial) // Compose Material
    implementation(Deps.navigationCompose) // Navigation Compose
    implementation(Deps.coilCompose) // Coil Compose

    implementation(Deps.retrofitSquareUp) // Retrofit (SquareUp)
    implementation(Deps.gsonConverterSquareUp) // Gson Converter (SquareUp)
    implementation(Deps.okHTTP) // OkHTTP (SquareUp)


    // Google Maps
              implementation (Deps.googleMapsCompose)
            implementation (Deps.mapsService)
            implementation (Deps.location)
            implementation (Deps.placesApi)
            implementation (Deps.mapsUtils)
}