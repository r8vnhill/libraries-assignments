rootProject.name = "libraries-assignments-kt"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }

    plugins {
        kotlin("jvm") version extra["kotlin.version"] as String
        id("io.gitlab.arturbosch.detekt") version
                extra["detekt.version"] as String
    }
}
