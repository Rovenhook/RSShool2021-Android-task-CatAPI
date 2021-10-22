

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.8.0.0")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.18.1"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

subprojects {
    apply (plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        // Required to download KtLint
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(false)
    }
}

detekt {
    toolVersion = "1.18.1"
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true

    input = files("app/src/main/java", "app/src/main/kotlin")

    reports {
        html.enabled = true
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = "1.8"
}
