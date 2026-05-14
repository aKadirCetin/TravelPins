plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.kadircetin.travelpins"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.kadircetin.travelpins"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Room library version
    val room_version = "2.6.1"

    // Google Maps SDK for displaying maps
    implementation("com.google.android.gms:play-services-maps:18.2.0")

    // Core Room database library
    implementation("androidx.room:room-runtime:$room_version")

    // Room annotation processor for generating database code
    ksp("androidx.room:room-compiler:$room_version")

    // RxJava3 support for Room database operations
    implementation("androidx.room:room-rxjava3:$room_version")

    // RxAndroid for Android-specific RxJava features
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    // Kotlin extensions and coroutine support for Room
    implementation("androidx.room:room-ktx:$room_version")
}