plugins {
    id("com.android.application")
}

android {
    namespace = "com.huynhnamvu.weatherapp"
    compileSdk = 34
buildFeatures{
    viewBinding=    true
}
    defaultConfig {
        applicationId = "com.huynhnamvu.weatherapp"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation ("androidx.room:room-runtime:2.4.0")
    implementation("com.google.android.libraries.places:places:3.3.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    annotationProcessor ("androidx.room:room-compiler:2.4.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.android.volley:volley:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //  lottie animations
    implementation ("com.airbnb.android:lottie:6.1.0")
    // GSON converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
}