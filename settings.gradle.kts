pluginManagement {
    repositories {
        // 阿里云公共镜像：加速 Gradle 插件下载（含 Maven Central 代理）
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        // 阿里云 Google 镜像：加速 AGP、Kotlin Gradle Plugin 等插件下载
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        // Google 官方插件仓库（AGP、Firebase 等插件的权威来源）
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        // Maven 中央仓库（开源库主要来源）
        mavenCentral()
        // Gradle 官方插件门户（第三方 Gradle 插件来源）
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    // FAIL_ON_PROJECT_REPOS：禁止子模块单独声明仓库，所有下载源统一在此管理
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 阿里云公共镜像：加速 Maven Central 依赖下载
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        // 阿里云 Google 镜像：加速 AndroidX、Material 等依赖下载
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        // Google 官方仓库（AndroidX、Material Design、Firebase 等）
        google()
        // Maven 中央仓库
        mavenCentral()
    }
}

// 项目逻辑名称（显示在 Android Studio 左侧项目面板）
rootProject.name = "DebugDemo"
// 包含的子模块（:app 是应用主模块，多模块项目可在此追加）
include(":app")