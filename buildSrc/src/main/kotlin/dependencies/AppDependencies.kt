package dependencies

/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
object AppDependencies {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val multidex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val supportV4 by lazy { "androidx.legacy:legacy-support-v4:${Versions.supportV4}" }
    val androidxKtx by lazy { "androidx.core:core-ktx:${Versions.androidxKtx}" }

    val koin by lazy { "io.insert-koin:koin-core:${Versions.koin}" }
    val koinAndroid by lazy { "io.insert-koin:koin-android:${Versions.koin}" }

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.room}" }
    val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }

    //Testing Dependencies
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
}