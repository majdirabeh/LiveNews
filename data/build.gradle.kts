import dependencies.AppDependencies
import dependencies.AppConfig

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdk

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    api(project(":domain"))
    api(AppDependencies.retrofit)
    api(AppDependencies.moshiConverter)
    api(AppDependencies.okhttp)
    api(AppDependencies.loggingInterceptor)

    api(AppDependencies.roomRuntime)
    kapt(AppDependencies.roomCompiler)
    api(AppDependencies.roomKtx)

}