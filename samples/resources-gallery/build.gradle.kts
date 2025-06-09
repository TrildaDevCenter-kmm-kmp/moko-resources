/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(moko.resourcesGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.21")
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.8.1")
        classpath("org.jetbrains.kotlin.plugin.compose:org.jetbrains.kotlin.plugin.compose.gradle.plugin:2.1.21")
        classpath("com.android.tools.build:gradle:8.9.3")
    }
}

subprojects {
    plugins.withType<com.android.build.gradle.BasePlugin> {
        configure<BaseExtension> {
            defaultConfig.minSdkVersion(16)
            compileSdkVersion(33)

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
    }
    plugins.withType<KotlinPluginWrapper> {
        configure<KotlinProjectExtension> {
            jvmToolchain(17)
        }
    }
}
