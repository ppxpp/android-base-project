# AndroidBaseProject

> Android 移动应用开发课程 · 知识点演示 & 实验模板项目

---

## 项目简介

本项目面向 Android 移动应用开发课程，承担两个核心职责：

1. **知识点演示（Demo）**：以可交互的 Fragment 演示课程各章节的关键知识点，辅助课堂讲解与学生自学。
2. **实验模板（Lab Template）**：为每个实验提供预置好的页面框架，学生只需在指定区域填写实验代码，无需从零搭建环境。

---

## 技术规格

| 项目 | 版本 / 值 |
|---|---|
| Android Gradle Plugin | 9.0.1 |
| Gradle | 9.1.0 |
| Kotlin | 内置（AGP 9.0+ Built-in Kotlin，基于 KGP 2.2.10） |
| compileSdk / targetSdk | 36 |
| minSdk | 24（Android 7.0+） |
| 主题 | Material3 · `Theme.AndroidTech` · DayNight · NoActionBar |
| 应用包名 | `cn.edu.sziit.android.tech` |
| 架构 | 多模块（`:app` + `:demo`） |
| ViewBinding | 已启用 |

### 依赖库

| 库 | 版本 | 用途 |
|---|---|---|
| `androidx.core:core-ktx` | 1.18.0 | Kotlin 扩展函数 |
| `androidx.appcompat:appcompat` | 1.7.1 | 向下兼容 Activity/Fragment |
| `com.google.android.material:material` | 1.13.0 | Material Design 3 组件 |
| `androidx.activity:activity` | 1.13.0 | 现代 Activity 基类 |
| `androidx.constraintlayout:constraintlayout` | 2.2.1 | 约束布局 |
| `androidx.recyclerview:recyclerview` | 1.4.0 | 章节导航列表 |

---

## 多模块架构

```
AndroidBaseProject/
├── app/                            # 主应用模块（Lab Template）
│   └── src/main/
│       ├── java/.../
│       │   ├── MainActivity.kt       # 首页：章节导航（展开式列表）
│       │   └── chapter4/s1layout/
│       │       ├── Ch4S1LinearLabActivity.kt     # 4.1 线性布局实验模板
│       │       └── Ch4S1ConstraintLabActivity.kt # 4.1 约束布局实验模板
│       └── res/
│           ├── layout/               # 布局文件
│           └── drawable/             # 图形资源（bg_calculator_btn.xml 等）
│
└── demo/                           # 演示模块（Android Library）
    └── src/main/
        └── java/.../
            ├── common/
            │   ├── ExpandableMenuAdapter.kt  # 首页章节展开菜单
            │   ├── MenuEntryAdapter.kt       # 小节列表菜单
            │   ├── ChapterGroup.kt           # 章节数据模型
            │   └── MenuEntry.kt              # 菜单项数据模型
            └── chapter4/
                ├── Ch4Activity.kt            # 第4章小节列表
                └── s1layout/
                    ├── Ch4S1Activity.kt         # 4.1 实验/演示入口列表
                    ├── Ch4S1DemoActivity.kt      # Demo Fragment 容器
                    └── demo/
                        ├── VisibilityFragment      # visibility 属性演示
                        ├── GravityFragment         # gravity 对齐演示
                        ├── PaddingMarginFragment    # padding/margin 演示
                        ├── LayoutSizeFragment       # layout_width/height 演示
                        ├── OrientationFragment      # orientation 演示
                        └── ConstraintFragment       # ConstraintLayout 演示
```

### 模块职责分工

| 模块 | 职责 | 包名 |
|---|---|---|
| `:app` | 首页导航 + 所有实验模板 Activity | `cn.edu.sziit.android.tech` |
| `:demo` | 章节导航页 + 所有知识点演示 Fragment | `cn.edu.sziit.android.tech.demo` |

跨模块跳转（`:demo` → `:app` 实验页）通过 **Intent Action** 解耦：

```
cn.edu.sziit.android.tech.lab.CH4_S1_LINEAR    → Ch4S1LinearLabActivity
cn.edu.sziit.android.tech.lab.CH4_S1_CONSTRAINT → Ch4S1ConstraintLabActivity
```

---

## 导航层级

```
MainActivity（首页章节目录）
└── Ch4Activity（第4章小节列表）
    └── Ch4S1Activity（4.1 实验/演示列表）
        ├── Ch4S1LinearLabActivity     （实验：线性布局）
        ├── Ch4S1ConstraintLabActivity （实验：约束布局）
        └── Ch4S1DemoActivity          （知识点演示容器）
            ├── VisibilityFragment
            ├── GravityFragment
            ├── PaddingMarginFragment
            ├── LayoutSizeFragment
            ├── OrientationFragment
            └── ConstraintFragment
```

---

## 新增章节 / 小节 / 演示的方式

### 新增演示 Fragment

1. 在 `demo/.../chapter4/s1layout/demo/` 下创建新 Fragment 类和布局文件
2. 在 `Ch4S1DemoActivity` 中添加 TAG 常量，并在 `when` 分支中注册
3. 在 `Ch4S1Activity` 的 `entries` 列表中追加对应 `MenuEntry`

### 新增实验 Activity

1. 在 `app/.../chapterX/` 下创建实验 Activity 类和布局文件
2. 在 `app/AndroidManifest.xml` 中注册，并设置唯一 `intent-filter` Action
3. 在 `:demo` 对应小节的 Activity 中追加 `MenuEntry(action = "...")`

### 新增章节

1. 在 `:demo` 中创建 `ChapterX/` 目录，仿照 `Ch4Activity` / `Ch4S1Activity` 新建导航 Activity
2. 在 `MainActivity.kt` 的 `chapters` 列表中追加 `ChapterGroup`

---

## 构建与运行

```bash
# Android Studio 中直接点击 Run，或命令行：
./gradlew assembleDebug
```

---

## 注意事项

- Gradle 从 `services.gradle.org` 下载（9.1.0），首次同步需网络；依赖通过阿里云镜像加速
- AGP 9.0 使用内置 Kotlin，无需手动声明 `kotlin-android` 插件
- PowerShell 写入任何文件时，必须使用 `New-Object System.Text.UTF8Encoding($false)` 创建无 BOM 的 UTF-8 编码，否则 AAPT2 解析 XML 时会崩溃
- `:demo` 模块的 `AndroidManifest.xml` 须使用**完整限定类名**（非相对包名），避免合并后解析错误
