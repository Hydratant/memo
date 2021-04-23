plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")

}
android {

    compileSdkVersion(ProjectConfig.compileSdkVersion)
    buildToolsVersion(ProjectConfig.buildToolVersion)

    defaultConfig {
        applicationId(ProjectConfig.applicationId)
        minSdkVersion(ProjectConfig.minSdkVersion)
        targetSdkVersion(ProjectConfig.targetSdkVersion)
        versionCode(ProjectConfig.versionCode)
        versionName(ProjectConfig.versionName)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}
dependencies {
    implementation(Kotlin.kotlinStdLib)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.UI.constraintLayout)
    implementation(AndroidX.UI.recyclerView)
    implementation(AndroidX.UI.viewpager2)

    implementation(Material.material)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)

    implementation(Timber.timber)

    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.mockitoInline)
    testImplementation(UnitTest.mockitoKotlin)
    testImplementation(UnitTest.hamcrest)
    testImplementation(UnitTest.robolectric)
    implementation(UnitTest.testCore)

    implementation(project(":data"))
    implementation(project(":domain"))

}
