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
        versionCode = 20
        versionName = "2.0-androidx"
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.webkit:webkit:1.12.1")
}
