plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.actor.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.actor.app"
        minSdk = 26
        targetSdk = 35
        versionCode = 41
        versionName = "4.1-known-actors"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
}
