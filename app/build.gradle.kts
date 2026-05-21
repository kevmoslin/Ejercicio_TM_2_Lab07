plugins {

    alias(libs.plugins.android.application)

    kotlin("android")

    kotlin("kapt")
}

android {
    namespace = "com.kevinmostacero.sistemaarticulos"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.kevinmostacero.sistemaarticulos"
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

        sourceCompatibility = JavaVersion.VERSION_21

        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {

        jvmTarget = "21"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    val roomVersion = "2.7.0"

    implementation("androidx.room:room-runtime:$roomVersion")

    implementation("androidx.room:room-ktx:$roomVersion")

    kapt("androidx.room:room-compiler:$roomVersion")

    implementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
    )
}