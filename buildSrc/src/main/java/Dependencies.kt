// File: buildSrc/src/main/java/Dependencies.kt

object Versions {
    const val core = "1.9.0"
    const val appcompat = "1.5.1"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "1.0.1"

    const val testRunner = "1.5.2"
    const val testImplJUnit = "4.13.2"
    const val androidTestImplJUnit = "1.1.3"
    const val androidTestEspresso = "3.4.0"

    const val retrofit = "2.9.0"
    const val gsonConverter = "2.9.0"
    const val okHttp = "4.9.0"
    const val scalarConverter = "2.1.0"

    const val kotlinCoroutines = "1.6.1"
    const val coroutineLifecycleScope = "2.5.1"
    const val glide = "4.12.0"

    const val viewModelDelegate = "1.6.0"
    const val dagger = "2.46"
    const val hiltCompiler = "1.0.0"
    const val hiltComposeNavigation = "1.0.0"

    const val roomVersion = "2.6.0-alpha01"
    const val swipeRefresh = "1.1.0"
    const val lottieAnimations = "3.4.2"

    const val composeUiVersion = "1.3.3"
    const val composeActivity = "1.6.1"
    const val composeMaterial = "1.3.1"
    const val composeNavigation = "2.6.0-alpha05"
    const val coilImageLoading = "2.2.2"

    const val kotlinCoroutineTest = "1.6.4"
    const val turbine = "0.12.1"
    const val mockito = "3.9.0"
    const val mockitoKotlin = "2.0.0"
    const val mockitoInline = "2.25.0"

    const val daggerHiltTestImpl = "2.44"
    const val daggerHiltAndroidTestImpl = "2.44"
    const val constraintLayoutForCompose = "1.1.0-alpha09"
    // Google Maps
    const val googleMapsCompose = "6.1.0"
    const val mapsService = "19.0.0"
    const val location = "21.3.0"
    const val placesApi = "3.3.0"
    const val mapsUtils = "3.8.2"
}

object Deps {
    // Core Libraries
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}" // Core KTX
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}" // AppCompat
    const val material = "com.google.android.material:material:${Versions.androidMaterial}" // Material Design
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}" // Constraint Layout

    // Testing Libraries
    const val junit = "junit:junit:${Versions.testImplJUnit}" // JUnit
    const val androidTestJUnit = "androidx.test.ext:junit:${Versions.androidTestImplJUnit}" // Android Test JUnit
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}" // Espresso

    // Network Libraries
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}" // Retrofit
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" // Gson Converter
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}" // OkHttp
    const val scalarConverter = "com.squareup.retrofit2:converter-scalars:${Versions.scalarConverter}" // Scalar Converter

    // Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}" // Kotlin Coroutines Core
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleScope}" // Lifecycle Runtime KTX

    // Image Loading
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}" // Glide

    // Jetpack Compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.composeActivity}" // Activity Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeUiVersion}" // Compose UI
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}" // Compose Material
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.composeNavigation}" // Navigation Compose
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilImageLoading}" // Coil Compose

    // Specific Versions
    const val retrofitSquareUp = "com.squareup.retrofit2:retrofit:2.9.0" // Retrofit (SquareUp)
    const val gsonConverterSquareUp = "com.squareup.retrofit2:converter-gson:2.9.0" // Gson Converter (SquareUp)
    const val okHTTP = "com.squareup.okhttp3:okhttp:3.4.1" // OkHTTP (SquareUp)


    // Google Maps
    const val googleMapsCompose = "com.google.maps.android:maps-compose:${Versions.googleMapsCompose}" // Google Maps Compose
    const val mapsService = "com.google.android.gms:play-services-maps:${Versions.mapsService}" // Maps Service
    const val location = "com.google.android.gms:play-services-location:${Versions.location}" // Location Services
    const val placesApi = "com.google.android.libraries.places:places:${Versions.placesApi}" // Places API
    const val mapsUtils = "com.google.maps.android:android-maps-utils:${Versions.mapsUtils}" // Maps Utils




}
