plugins {
    kotlin("jvm")
}

allprojects {
    group = "libraries-assignments-kt"
    version = extra["libraries-assignments-kt.version"] as String
}

subprojects {
    repositories {
        mavenCentral()
    }
}
