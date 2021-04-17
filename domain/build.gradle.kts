plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(ProjectConfig.compileSdkVersion)
    buildToolsVersion(ProjectConfig.buildToolVersion)

    defaultConfig {
        minSdkVersion(ProjectConfig.minSdkVersion)
        targetSdkVersion(ProjectConfig.targetSdkVersion)
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Kotlin.kotlinStdLib)
    implementation(Timber.timber)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)

    implementation(project(":data"))
}