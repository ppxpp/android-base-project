# AndroidBaseProject

> 深信院 Android 移动应用开发课程基础模板项目

---

## 项目简介

本项目是一个经过精简和现代化配置的 Android 模板项目，作为课程实验的统一起点。  
使用前只需修改少量配置，即可快速开始每次实验，无需从空项目反复搭建环境。

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
| 包名 | `cn.edu.sziit.android.tech` |
| 入口 Activity | `EntryActivity`（纯代码 UI，无 XML 布局） |
| ViewBinding | 已启用 |

### 依赖库

| 库 | 版本 | 用途 |
|---|---|---|
| `androidx.core:core-ktx` | 1.18.0 | Kotlin 扩展函数 |
| `androidx.appcompat:appcompat` | 1.7.1 | 向下兼容 Activity/Fragment |
| `com.google.android.material:material` | 1.13.0 | Material Design 3 组件 |
| `androidx.activity:activity` | 1.13.0 | 现代 Activity 基类 |
| `androidx.constraintlayout:constraintlayout` | 2.2.1 | 约束布局 |

---

## 项目结构

```
AndroidBaseProject/
├── app/
│   ├── src/main/
│   │   ├── java/cn/edu/sziit/android/tech/
│   │   │   └── EntryActivity.kt        # 默认入口，纯代码 UI
│   │   ├── res/
│   │   │   ├── drawable/               # 启动图标矢量素材
│   │   │   ├── mipmap-anydpi-v26/      # 自适应图标（API 26+）
│   │   │   ├── mipmap-xxhdpi/          # 旧版设备回退图标
│   │   │   └── values/
│   │   │       ├── colors.xml          # 品牌颜色（Material3 主色系由主题管理）
│   │   │       ├── strings.xml         # 字符串资源
│   │   │       └── themes.xml          # 应用主题定义
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts               # 模块构建脚本（含详细注释）
├── gradle/
│   ├── libs.versions.toml             # 版本目录（统一管理依赖版本）
│   └── wrapper/
│       └── gradle-wrapper.properties  # Gradle 发行版配置
├── build.gradle.kts                   # 根项目构建脚本
├── settings.gradle.kts                # 项目设置（仓库镜像、模块声明）
├── gradle.properties                  # 全局 Gradle 属性（性能优化）
└── .gitignore
```

---

## 基于本模板创建新实验项目时，需修改的地方

创建新实验时，以最小改动原则，按以下顺序修改：

### 1. 修改应用标识（必改）

**文件：`app/build.gradle.kts`**
```kotlin
// 将 applicationId 改为本次实验的唯一标识
applicationId = "cn.edu.sziit.android.实验名称"
```

**文件：`settings.gradle.kts`**
```kotlin
// 修改项目逻辑名称
rootProject.name = "实验项目名称"
```

### 2. 修改包名（建议）

**在 Android Studio 中右键包名目录 → Refactor → Rename**，将 `cn.edu.sziit.android.tech` 改为对应实验的包名，同时更新 `build.gradle.kts` 中的 `namespace`。

### 3. 修改入口 Activity（必改）

**文件：`EntryActivity.kt`**  
删除提示文字，根据实验需求实现实际界面。  
如需使用 XML 布局：
1. 在 `res/layout/` 创建布局文件（目录需手动创建）
2. 使用 ViewBinding：`val binding = ActivityXxxBinding.inflate(layoutInflater)`

### 4. 修改应用名称（建议）

**文件：`res/values/strings.xml`**
```xml
<string name="app_name">实验应用名称</string>
```

### 5. 可选修改

- **主题颜色**：在 `res/values/themes.xml` 中的 `Theme.AndroidTech` 样式内添加 `colorPrimary` 等条目
- **最低 SDK**：如实验需要更高 API，修改 `build.gradle.kts` 中的 `minSdk`
- **依赖库**：在 `gradle/libs.versions.toml` 添加版本，在 `app/build.gradle.kts` 中 `implementation()`

---

## 构建与运行

```bash
# 直接在 Android Studio 中点击 Run，或：
./gradlew assembleDebug
```

---

## 注意事项

- Gradle 从 `services.gradle.org` 下载（9.1.0），首次同步需要网络
- 依赖库通过阿里云镜像加速下载（`maven.aliyun.com`）
- AGP 9.0 使用内置 Kotlin，无需手动声明 `kotlin-android` 插件
- ViewBinding 已全局启用，新增布局文件后自动生成对应绑定类

---

*深圳信息职业技术学院 · Android 移动应用开发课程*
