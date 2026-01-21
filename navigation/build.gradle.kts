plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    kotlin("plugin.serialization") version "2.3.0"
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidLibrary {
        namespace = "dev.percym.navigation"
        compileSdk = 36
        minSdk = 24
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(project(":auth"))
            implementation(project(":shared"))
            implementation(project(":home"))
            implementation(libs.compose.navigation)
            implementation(libs.kotlinx.serialization)
        }
    }
}
