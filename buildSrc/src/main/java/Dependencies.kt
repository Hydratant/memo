object Kotlin {
    private const val kotlinVersion = "1.4.32"
    const val gradlePluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
}

object Gradle {
    private const val gradleVersion = "4.1.3"
    const val gradleBuildTool = "com.android.tools.build:gradle:${gradleVersion}"
}

object AndroidX {
    private const val coreKtxVersion = "1.3.2"
    const val coreKtx = "androidx.core:core-ktx:${coreKtxVersion}"

    private const val appcompatVersion = "1.2.0"
    const val appcompat = "androidx.appcompat:appcompat:${appcompatVersion}"

    object UI {
        private const val constraintLayoutVersion = "2.0.4"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"

        private const val recyclerViewVersion = "1.1.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:${recyclerViewVersion}"

        private const val viewPager2Version = "1.0.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:$viewPager2Version"

        private const val cardViewVersion = "1.0.0"
        const val cardView = "androidx.cardview:cardview:$cardViewVersion"
    }

    object KTX {
        private const val viewModelVersion = "2.3.1"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion"

        private const val fragmentVersion = "1.3.3"
        const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
    }


}

object Material {
    private const val materialVersion = "1.3.0"
    const val material = "com.google.android.material:material:${materialVersion}"
}


object Hilt {
    private const val daggerHiltVersion = "2.34.1-beta"
    const val gradlePluginDaggerHilt =
        "com.google.dagger:hilt-android-gradle-plugin:${daggerHiltVersion}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${daggerHiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${daggerHiltVersion}"

    const val hiltTest = "com.google.dagger:hilt-android-testing:$daggerHiltVersion"
}


object Room {
    private const val roomVersion = "2.2.6"
    const val room = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    const val roomTesting = "androidx.room:room-testing:$roomVersion"
}

object Coroutine {
    private const val coroutineVersion = "1.4.3"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutineVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"
}


object Timber {
    private const val timberVersion = "4.7.1"
    const val timber = "com.jakewharton.timber:timber:$timberVersion"
}

@Suppress("SpellCheckingInspection")
object Utils {
    private const val stethoVersion = "1.5.1"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
}


