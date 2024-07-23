plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")

}

android {
    namespace = "com.studiesLocation.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    implementation(project(":location:domain"))
    implementation(project(":location:data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.ui.tooling.preview.desktop)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")

    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("com.google.accompanist:accompanist-permissions:0.21.1-beta")


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