plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "${Configuration.appIdDomain}.core_ui"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.Google.material)

    with(Deps.Project) {
        implementation(project(core))
    }

    with(Deps.AndroidX.Compose) {
        implementation(platform(bom))
        implementation(ui)
        implementation(uiGraphics)
        implementation(uiToolingPreview)
        implementation(material3)
        implementation(navigation)
    }

    with(Deps.AndroidX.Test.UI) {
        androidTestImplementation(uiTest)
        debugImplementation(uiTooling)
        debugImplementation(testManifest)
    }

    // TEST
    testImplementation(Deps.JUnit.junit4)
    with(Deps.AndroidX.Test) {
        androidTestImplementation(extJunit)
        androidTestImplementation(espresso)
    }
}