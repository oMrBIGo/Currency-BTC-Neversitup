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
    const val room = "2.2.5"
    const val gson = "2.8.6"
    const val preference = "1.1.1"
    const val koin = "2.1.6"
    const val navigation = "2.4.2"
    const val fragment = "1.2.5"
    const val lifecycle = "2.2.0"
    const val appcompat = "1.2.0"
    const val recyclerview = "1.1.0"
    const val constraintLayout = "2.0.0-rc1"
    const val coreKtx = "1.3.1"
    const val stetho = "1.5.1"
    const val chucker = "3.5.2"
    const val store = "4.0.0-alpha06"
    const val coil = "1.0.0-rc3"
    const val timber = "4.7.1"
    const val junit = "1.1.0"
    const val robolectric = "4.3.1"
    const val mockK = "1.9.3"
    const val test = "1.2.0"
    const val archCore = "2.1.0"
    const val espresso = "3.1.0"
    const val security = "1.1.0-alpha02"
    const val circleImageView = "3.1.0"
    const val viewpager2 = "1.0.0"
    const val scrollingpagerindicator = "1.2.1"
    const val imageSupport = "2.0.0"
    const val dotsIndicator = "4.3"
    const val loopingViewpager = "0.2.0"
    const val flexbox = "2.0.1"
    const val swiperefreshlayout = "1.0.0"
    const val browser = "1.3.0"
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
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val coilGif = "io.coil-kt:coil-gif:${Versions.coil}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
    const val scrollingpagerindicator =
        "ru.tinkoff.scrollingpagerindicator:scrollingpagerindicator:${Versions.scrollingpagerindicator}"
    const val dotsIndicator = "com.tbuonomo:dotsindicator:${Versions.dotsIndicator}"
    const val loopingViewpager =
        "com.kenilt.loopingviewpager:loopingviewpager:${Versions.loopingViewpager}"
    const val flexbox = "com.google.android:flexbox:${Versions.flexbox}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val browser =
        "androidx.browser:browser:${Versions.browser}"

    // data
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val preference = "androidx.preference:preference:${Versions.preference}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val store = "com.dropbox.mobile.store:store4:${Versions.store}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val security = "androidx.security:security-crypto:${Versions.security}"

    // log
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val stetho = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    //ImageBadge
    const val imageSupport = "io.github.nikartm:image-support:${Versions.imageSupport}"

}

object TestDeps {
    const val testCore = "androidx.test:core:${Versions.test}"
    const val testRunner = "androidx.test:runner:${Versions.test}"
    const val testRules = "androidx.test:rules:${Versions.test}"
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val mockk = "io.mockk:mockk:${Versions.mockK}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockK}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val koin = "org.koin:koin-test:${Versions.koin}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
