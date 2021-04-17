buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Gradle.gradleBuildTool)
        classpath(Kotlin.gradlePluginKotlin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
