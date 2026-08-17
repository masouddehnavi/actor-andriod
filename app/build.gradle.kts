plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }
android { namespace="com.actor.app"; compileSdk=35
 defaultConfig { applicationId="com.actor.app"; minSdk=26; targetSdk=35; versionCode=40; versionName="4.0-main" }
 compileOptions { sourceCompatibility=JavaVersion.VERSION_17; targetCompatibility=JavaVersion.VERSION_17 }
 kotlinOptions { jvmTarget="17" } }
dependencies { implementation("androidx.appcompat:appcompat:1.7.0") }