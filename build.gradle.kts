/**
 * build.gradle.kts — 根项目构建脚本
 *
 * 本文件是整个项目的顶层构建脚本，作用：
 *  - 声明所有子模块公用的插件版本（使用 apply false 表示仅声明、不应用）
 *  - 子模块（如 :app）通过 alias(libs.plugins.xxx) 按需应用
 *
 * 注意：具体依赖和编译配置请在 app/build.gradle.kts 中配置。
 */

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Android 应用插件（仅声明版本，:app 模块中应用）
    alias(libs.plugins.android.application) apply false
    // Android 库插件（仅声明版本，:demo 等库模块中应用）
    alias(libs.plugins.android.library) apply false
}