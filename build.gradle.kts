// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.set("kotlinVersion", "1.4.10")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        val kotlinVersion: String by rootProject.extra
        classpath("com.android.tools.build:gradle:4.2.0-alpha13")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

val clean by tasks.creating(Delete::class) {
    delete = setOf(rootProject.buildDir)
}