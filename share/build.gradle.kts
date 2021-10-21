plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(ProjectConfig.compileSdkVersion)

    defaultConfig {
        minSdkVersion(ProjectConfig.minSdkVersion)
        targetSdkVersion(ProjectConfig.targetSdkVersion)
    }
}

dependencies {
    implementation(Kotlin.kotlinStdLib)
    implementation(Timber.timber)

    implementation(Inject.inject)

    // Coroutine
    implementation(Coroutine.coroutine)
    implementation(Coroutine.coroutinesAndroid)
    testImplementation(Coroutine.coroutineTest)
}