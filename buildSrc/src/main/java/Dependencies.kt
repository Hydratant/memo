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
    }
}

