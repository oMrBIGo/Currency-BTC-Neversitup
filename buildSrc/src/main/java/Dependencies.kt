object ApplicationId {
    const val id = "org.nathit.currencybtc"
}

object Modules {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
    const val navigation = ":navigation"
    const val commonUi = ":common-ui"
    const val commonRes = ":common-res"
    const val featureHome = ":features:home"
    const val featureConvert = ":features:convert"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk = 32
}

object Versions {
    const val androidGradle = "4.0.1"
    const val kotlin = "1.4.21"
    const val material = "1.6.1"
    const val coroutines = "1.3.8"
    const val okhttp = "4.9.0"
    const val retrofit = "2.9.0"
    const val gson = "2.8.6"
    const val koin = "2.1.6"
    const val navigation = "2.4.2"
    const val fragment = "1.2.5"
    const val appcompat = "1.2.0"
    const val recyclerview = "1.1.0"
    const val constraintLayout = "2.0.0-rc1"
    const val coreKtx = "1.3.1"
    const val chucker = "3.5.2"
}

object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinExtensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"

    // di
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // navigation
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationSafeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    // ui
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val material = "com.google.android.material:material:${Versions.material}"

    // data
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // log
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
}
