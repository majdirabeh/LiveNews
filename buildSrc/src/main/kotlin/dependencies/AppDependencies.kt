package dependencies

/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
object AppDependencies {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    val koin by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
    val koinCore by lazy { "io.insert-koin:koin-core:${Versions.koin}" }

    //Testing Dependencies
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
}