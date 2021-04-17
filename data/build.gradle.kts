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

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
    testOptions.unitTests {
        isIncludeAndroidResources = true
    }
}

dependencies {
    implementation(Kotlin.kotlinStdLib)
    implementation(Timber.timber)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    testImplementation(Hilt.hiltTest)
    kaptTest(Hilt.hiltCompiler)

    // Room
    implementation(Room.room)
    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)
    testImplementation(Room.roomTesting)

    // Coroutine
    implementation(Coroutine.coroutine)
    implementation(Coroutine.coroutinesAndroid)
    testImplementation(Coroutine.coroutineTest)

    // Testing
    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.mockitoInline)
    testImplementation(UnitTest.mockitoKotlin)
    testImplementation(UnitTest.hamcrest)
    testImplementation(UnitTest.robolectric)
    implementation(UnitTest.testCore)
}