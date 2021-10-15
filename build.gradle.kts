buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Gradle.gradleBuildTool)
        classpath(Kotlin.gradlePluginKotlin)
        classpath(Hilt.gradlePluginDaggerHilt)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
