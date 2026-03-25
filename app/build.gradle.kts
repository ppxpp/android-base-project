/**
 * app/build.gradle.kts — 应用模块构建脚本
 *
 * 本文件配置 :app 模块的编译参数、依赖和构建变体。
 * 所有依赖版本号统一在 gradle/libs.versions.toml 中管理。
 */

plugins {
    // 应用 Android 应用插件（AGP 9.0+ 内置 Kotlin 支持，无需再声明 kotlin-android）
    alias(libs.plugins.android.application)
}

android {
    // 命名空间：用于生成 R 类，替代旧版 AndroidManifest.xml 中的 package 属性
    namespace = "cn.edu.sziit.android.debugdemo"

    // compileSdk：编译时使用的 Android API 级别（不影响运行时最低版本要求）
    compileSdk = 36

    defaultConfig {
        // 应用唯一标识符，发布到应用商店时使用此 ID
        applicationId = "cn.edu.sziit.android.debugdemo"
        // 最低支持的 Android 版本（API 24 = Android 7.0 牛轧糖）
        minSdk = 24
        // 目标 API 级别：应用针对此版本进行优化和测试
        targetSdk = 36
        // 内部版本号，每次发布必须递增
        versionCode = 1
        // 用户可见的版本名称
        versionName = "1.0"
    }

    buildTypes {
        release {
            // 发布包默认关闭代码混淆（教学模板；实际项目建议开启）
            isMinifyEnabled = false
            proguardFiles(
                // AGP 内置的优化混淆规则（已比 proguard-android.txt 更激进）
                getDefaultProguardFile("proguard-android-optimize.txt"),
                // 项目自定义混淆规则文件
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        // Java 源码兼容级别（与 kotlinOptions 保持一致）
        sourceCompatibility = JavaVersion.VERSION_11
        // Java 字节码目标版本
        targetCompatibility = JavaVersion.VERSION_11
        // AGP 9.0 内置 Kotlin 会自动从 compileOptions 继承 JVM 目标，无需额外的 kotlinOptions
    }

    buildFeatures {
        // 启用 ViewBinding：为每个布局文件生成绑定类，替代 findViewById
        viewBinding = true
    }
}

dependencies {
    // AndroidX 核心 KTX：为常用 Android API 提供 Kotlin 扩展函数
    implementation(libs.androidx.core.ktx)
    // AppCompat：提供向下兼容的 AppCompatActivity 基类
    implementation(libs.androidx.appcompat)
    // Material Design 3：按钮、主题、导航栏等 UI 组件
    implementation(libs.material)
    // AndroidX Activity：现代 Activity 基类，支持 enableEdgeToEdge 等特性
    implementation(libs.androidx.activity)
    // ConstraintLayout：灵活的平面布局，适合复杂界面（如需用到时保留）
    implementation(libs.androidx.constraintlayout)
}