/**
 * Created by ozan on 4.01.2024
 */

object Deps {
    object Project {
        const val core = ":core"
        const val coreNetwork = ":core-network"
        const val coreLocal = ":core-local"
        const val homeUi = ":home-ui"
        const val loginUi = ":login-ui"
        const val movieUi = ":movie-ui"
    }

    object JUnit {
        const val junit4 = "junit:junit:4.13.2"
    }

    object Google {
        const val material = "com.google.android.material:material:1.11.0"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
        const val activityCompose = "androidx.activity:activity-compose:1.8.2"

        object Compose {
            const val ui = "androidx.compose.ui:ui"
            const val uiGraphics = "androidx.compose.ui:ui-graphics"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
            const val material3 = "androidx.compose.material3:material3"
            const val bom = "androidx.compose:compose-bom:2023.08.00"
        }

        object Test {
            const val extJunit = "androidx.test.ext:junit:1.1.5"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"

            object UI {
                const val uiTest = "androidx.compose.ui:ui-test-junit4"
                const val uiTooling = "androidx.compose.ui:ui-tooling"
                const val testManifest = "androidx.compose.ui:ui-test-manifest"
            }

        }
    }

    object Room {
        private const val version = "2.6.1"
        const val roomRuntime = "androidx.room:room-runtime:$version"
        const val roomCompiler = "androidx.room:room-compiler:$version"
        const val roomKTX = "androidx.room:room-ktx:$version"
    }

    object DaggerHilt {
        const val version = "2.50"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.1.0"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val plugin = "com.google.dagger.hilt.android"
    }

}