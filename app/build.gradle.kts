plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id(Deps.DaggerHilt.plugin)
}

android {
    namespace = "${Configuration.appIdDomain}.nextflix"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        applicationId = "${Configuration.appIdDomain}.nextflix"
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    with(Deps.AndroidX) {
        implementation(coreKtx)
        implementation(activityCompose)
    }

    implementation(Deps.AndroidX.LifeCycle.lifecycleOnly)

    with(Deps.AndroidX.Compose) {
        implementation(platform(bom))
        implementation(ui)
        implementation(uiGraphics)
        implementation(uiToolingPreview)
        implementation(material3)
        implementation(navigation)
    }

    with(Deps.Project) {
        implementation(project(core))
        implementation(project(coreLocal))
        implementation(project(coreNetwork))
        implementation(project(homeUi))
        implementation(project(loginUi))
        implementation(project(movieUi))
        implementation(project(coreUi))
    }

    with(Deps.DaggerHilt) {
        implementation(hiltAndroid)
        kapt(hiltCompiler)
    }

    // TESTS
    testImplementation(Deps.JUnit.junit4)
    androidTestImplementation(platform(Deps.AndroidX.Compose.bom))
    with(Deps.AndroidX.Test) {
        androidTestImplementation(extJunit)
        androidTestImplementation(espresso)
    }

    with(Deps.AndroidX.Test.UI) {
        androidTestImplementation(uiTest)
        debugImplementation(uiTooling)
        debugImplementation(testManifest)
    }
}