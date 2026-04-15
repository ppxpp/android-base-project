/**
 * demo/build.gradle.kts — :demo 演示模块构建脚本（Android Library）
 *
 * 包含所有导航目录页和效果演示 Fragment，以 AAR 形式提供给 :app 模块使用。
 * 实验框架页（Ch4S1LabActivity）保留在 :app，通过 Intent Action 解耦。
 */

plugins {
    alias(libs.plugins.android.library)
}

android {
    /**
     * namespace 与 :app 保持一致，使演示模块内的 R 引用、ViewBinding 绑定类包名
     * 无需改动，代码可直接迁移。
     */
    namespace = "cn.edu.sziit.android.tech.demo"

    compileSdk = 36

    defaultConfig {
        minSdk = 27
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
}
