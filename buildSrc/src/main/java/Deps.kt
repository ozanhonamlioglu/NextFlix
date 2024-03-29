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
        const val coreUi = ":core_ui"
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
        const val activityCompose = "androidx.activity:activity-compose:1.8.2"

        object LifeCycle {
            private const val lifecycle_version = "2.6.2"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
            const val lifecycleOnly = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
            const val lifecycleCompose = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version"
            const val processor = "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
            const val service = "androidx.lifecycle:lifecycle-service:$lifecycle_version"
            const val savedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui"
            const val uiGraphics = "androidx.compose.ui:ui-graphics"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
            const val material3 = "androidx.compose.material3:material3"
            const val bom = "androidx.compose:compose-bom:2023.08.00"
            const val navigation = "androidx.navigation:navigation-compose:2.7.6"
            const val extendedIcons = "androidx.compose.material:material-icons-extended"
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

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:4.12.0"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Serialization {
        const val kotlinx = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2"
    }

    object Image {
        const val coil = "io.coil-kt:coil-compose:2.5.0"
    }
}