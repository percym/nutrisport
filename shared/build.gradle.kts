plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.serialization)
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    jvm {
        withJava()
    }

    androidLibrary {
        namespace = "dev.percym.shared"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
    }

    val xcfName = "sharedKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.kotlinx.serialization)
                implementation(compose.material3)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        jvmMain {
            dependencies {
            }
        }

        androidMain {
            dependencies {
                // Import the Compose BOM
                implementation ("androidx.compose:compose-bom:2024.01.00")

                // Android Studio Preview support
                implementation ("androidx.compose.ui:ui-tooling-preview")

                // These MUST be "implementation" or "api" inside sourceSets
                // because KMP handles "debug" configurations differently
                implementation ("androidx.compose.ui:ui-tooling")
                implementation ("androidx.compose.ui:ui-test-manifest")
            }
        }
        androidUnitTest {
            dependencies {
                implementation ("androidx.compose:compose-bom:2024.01.00")
                implementation ("androidx.compose.ui:ui-test-junit4")
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
            }
        }
    }
}

compose.resources {
    publicResClass = true
//    packageOfResClass = "dev.percym.shared.generated.resources"
    generateResClass = always
}