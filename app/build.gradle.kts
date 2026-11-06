plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.nativeapp"
    compileSdk = 34
    ndkVersion = "26.1.10909125"

    defaultConfig {
        applicationId = "com.example.nativeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        ndk { abiFilters += listOf("arm64-v8a") }
        externalNativeBuild { cmake { cppFlags += "-std=c++17" } }
    }

    externalNativeBuild {
        cmake { path = file("src/main/cpp/CMakeLists.txt") }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
}
