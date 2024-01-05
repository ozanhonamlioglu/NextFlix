plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id(Deps.DaggerHilt.plugin)
}

android {
    namespace = "tech.eightbits.core_local"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

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

    with(Deps.Room) {
        implementation(roomRuntime)
        implementation(roomKTX)
        annotationProcessor(roomCompiler)
        kapt(roomCompiler)
    }

    implementation(project(Deps.Project.core))

    with(Deps.DaggerHilt) {
        implementation(hiltAndroid)
        kapt(hiltCompiler)
    }

    // TEST
    testImplementation(Deps.JUnit.junit4)
    with(Deps.AndroidX.Test) {
        androidTestImplementation(extJunit)
        androidTestImplementation(espresso)
    }
}