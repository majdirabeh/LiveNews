import dependencies.AppConfig
import dependencies.AppDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
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

    buildFeatures {
        dataBinding = true
        // for view binding:
        viewBinding = true
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {

    //Import local modules
    api(project(":data"))

    //Import remote dependency
    implementation(AppDependencies.kotlin)
    implementation(AppDependencies.appCompat)
    implementation(AppDependencies.supportV4)
    implementation(AppDependencies.androidxKtx)
    implementation(AppDependencies.multidex)
    implementation(AppDependencies.materialDesign)
    implementation(AppDependencies.constraintLayout)
    implementation(AppDependencies.lifecycle)
    implementation(AppDependencies.picasso)
    implementation(AppDependencies.kiel)

    //Test dependency
    testImplementation(AppDependencies.junit)
}