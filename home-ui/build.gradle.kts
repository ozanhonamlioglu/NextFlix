plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id(Deps.DaggerHilt.plugin)
}

android {
    namespace = "${Configuration.appIdDomain}.home_ui"
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
    implementation(Deps.AndroidX.activityCompose)
    implementation(Deps.Google.material)

    with(Deps.AndroidX.LifeCycle) {
        implementation(viewModel)
        implementation(viewModelCompose)
        implementation(lifecycleOnly)
        implementation(lifecycleCompose)
        implementation(savedState)
        kapt(processor)
    }

    with(Deps.Project) {
        implementation(project(core))
        implementation(project(coreLocal))
        implementation(project(coreNetwork))
        implementation(project(coreUi))
    }

    with(Deps.DaggerHilt) {
        implementation(hiltAndroid)
        kapt(hiltCompiler)
    }

    with(Deps.AndroidX.Compose) {
        implementation(platform(bom))
        implementation(ui)
        implementation(uiGraphics)
        implementation(uiToolingPreview)
        implementation(material3)
        implementation(navigation)
        implementation(extendedIcons)
    }

    // TEST
    testImplementation(Deps.JUnit.junit4)
    with(Deps.AndroidX.Test) {
        androidTestImplementation(extJunit)
        androidTestImplementation(espresso)
    }
}