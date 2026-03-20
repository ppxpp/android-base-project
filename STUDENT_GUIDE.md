# 实验项目导入与配置指南

> 适用对象：Android 移动应用开发课程学生（零基础）  
> 模板版本：AndroidBaseProject

---

## 目录

1. [准备工作](#1-准备工作)  
2. [下载并解压项目](#2-下载并解压项目)  
3. [将项目导入 Android Studio](#3-将项目导入-android-studio)  
4. [等待项目初始化（重要！）](#4-等待项目初始化重要)  
5. [了解项目结构](#5-了解项目结构)  
6. [修改项目配置（每次实验必做）](#6-修改项目配置每次实验必做)  
7. [创建你的第一个 Activity](#7-创建你的第一个-activity)  
8. [运行到模拟器或手机](#8-运行到模拟器或手机)  
9. [常见问题与解决方法](#9-常见问题与解决方法)

---

## 1. 准备工作

### 1.1 确保 Android Studio 已安装

- 打开 Android Studio，确认可以正常启动
- 推荐版本：**Android Studio Meerkat** 或更高版本
- 如果没有安装，请联系老师或参考[官方安装指南](https://developer.android.com/studio)

### 1.2 确保 JDK 已就绪

Android Studio 自带 JDK，**无需单独安装**，直接使用即可。

---

## 2. 下载并解压项目

### 2.1 获取项目 ZIP 文件

从老师提供的链接下载项目 ZIP 文件（文件名类似 `AndroidBaseProject.zip`）。

### 2.2 解压到合适的位置

**推荐解压路径**：`D:\AndroidProjects\` 或 `C:\Users\你的用户名\AndroidStudioProjects\`

> ❌ **避免**以下路径，可能导致编译失败：
> - 路径中含有中文字符（如 `桌面`、`下载`、`张三的项目`）
> - 路径中含有空格（如 `My Projects`）
> - 路径过深（如 `C:\Users\xxx\OneDrive\学习资料\大三上\移动开发\实验一\项目文件\AndroidBaseProject`）

**正确示例**：
```
D:\AndroidProjects\实验1\AndroidBaseProject
```

> ✅ `实验1` 包含中文没有关系，**项目目录本身的名字**不要带中文。

---

## 3. 将项目导入 Android Studio

### 步骤 1：打开 Android Studio

启动 Android Studio，在欢迎界面你会看到类似下图的选项：

```
Welcome to Android Studio
---------------------------------
  [ New Project ]
  [ Open ]            ← 点这个
  [ Get from VCS ]
```

或者如果已经打开了某个项目，点击顶部菜单 **File → Open...**

### 步骤 2：选择项目文件夹

在弹出的文件选择器中：
1. 导航到你解压的 `AndroidBaseProject` 文件夹
2. **选中该文件夹**（不要进入文件夹内部，选中文件夹本身）
3. 点击右下角的 **OK** 按钮

> 💡 判断是否选对了：正确的文件夹里应该包含 `build.gradle.kts`、`settings.gradle.kts`、`app/` 等文件。

### 步骤 3：选择信任项目

Android Studio 可能会弹出安全提示：

```
┌─────────────────────────────────────┐
│ Trust and Open Project?             │
│                                     │
│ [ Trust Project ]  [ Don't Open ]   │
└─────────────────────────────────────┘
```

点击 **Trust Project**（信任项目），继续。

---

## 4. 等待项目初始化（重要！）

### 为什么需要等待？

项目首次打开时，Android Studio 需要：
1. 下载 **Gradle 构建工具**（约 100MB，从网络下载，需要一定时间）
2. 下载项目所需的**依赖库**（AndroidX、Material 等，约 50-100MB）
3. 索引项目文件，建立代码提示

**总计可能需要 5~20 分钟**，取决于网络速度。

### 如何判断初始化是否完成？

**正在下载/编译的标志**（正常，耐心等待）：
- 底部状态栏显示进度条和文字，如 `Gradle: Downloading...`、`Syncing...`
- 右下角有旋转的进度图标

**初始化完成的标志**：
- 底部状态栏进度消失
- 左侧的 `Project` 文件树完整显示所有文件夹
- 顶部运行按钮（绿色三角形 ▶）变为可点击状态

> ⚠️ **在初始化完成之前，不要进行任何操作！** 等待完成后再继续以下步骤。

### 如果下载很慢或失败？

- 确保电脑连接了网络（优先使用校园网或稳定的 WiFi）
- 如果长时间卡在某一步，尝试：File → Sync Project with Gradle Files（重新同步）

---

## 5. 了解项目结构

项目初始化完成后，在左侧 **Project** 面板（切换到 **Android** 视图）中，你会看到如下结构：

```
app/
├── manifests/
│   └── AndroidManifest.xml        ← 应用清单，声明所有 Activity
├── java/
│   └── cn.edu.sziit.android.tech/
│       └── （空包，你的代码放这里）
└── res/
    ├── drawable/                   ← 图标资源（不需要修改）
    ├── mipmap-*/                   ← 应用图标（不需要修改）
    └── values/
        ├── colors.xml              ← 颜色定义
        ├── strings.xml             ← 字符串（应用名称在这里）
        └── themes.xml              ← 应用主题
```

> 💡 **Android 视图** 和 **Project 视图** 的切换：点击左侧 Project 面板顶部的下拉箭头，选择 `Android`。

---

## 6. 修改项目配置（每次实验必做）

每次基于本模板开始新实验时，**必须修改**以下内容，否则可能与他人的应用冲突或造成混乱。

---

### 6.1 修改应用名称

**文件**：`app/res/values/strings.xml`

**操作步骤**：
1. 在左侧 Project 面板中，展开 `app → res → values`
2. 双击打开 `strings.xml`
3. 找到以下内容：
   ```xml
   <string name="app_name">AndroidBaseProject</string>
   ```
4. 将 `AndroidBaseProject` 改为本次实验的应用名称，例如：
   ```xml
   <string name="app_name">实验一：计算器</string>
   ```

---

### 6.2 修改应用 ID（包名）

应用 ID 是应用在手机上的唯一标识，**每个实验应该使用不同的 ID**，否则安装到手机上会互相覆盖。

**文件**：`app/build.gradle.kts`

**操作步骤**：
1. 在左侧 Project 面板中，找到 `app` 模块下的 `build.gradle.kts`（注意不是根目录下的那个）
2. 双击打开，找到以下内容：
   ```kotlin
   applicationId = "cn.edu.sziit.android.tech"
   ```
3. 修改为包含你学号的唯一 ID，例如（学号末尾4位为 `1234`，实验编号为 `01`）：
   ```kotlin
   applicationId = "cn.edu.sziit.android.lab01.s1234"
   ```

**格式规则**：
- 只能包含 **英文字母、数字、点（.）**，不能有中文或空格
- 至少需要 **两段**（用 `.` 分隔），例如 `com.example.myapp`
- 每段不能以数字开头

---

### 6.3 修改 Namespace（可选，但建议修改）

如果你修改了 `applicationId`，建议同时修改 `namespace`（同在 `app/build.gradle.kts` 文件中）：

```kotlin
// 将这一行
namespace = "cn.edu.sziit.android.tech"
// 改为与 applicationId 一致的值
namespace = "cn.edu.sziit.android.lab01.s1234"
```

> 修改 `namespace` 后，如果已经写了 Kotlin 代码，需要同时更新代码文件顶部的 `package` 声明。  
> 如果你是刚开始写，还没有代码，则无需担心。

---

### 6.4 同步 Gradle

修改 `build.gradle.kts` 后，Android Studio 会在顶部弹出提示：

```
┌──────────────────────────────────────────────────────┐
│ Gradle files have changed since last project sync.   │
│                        [ Sync Now ]  [ Dismiss ]     │
└──────────────────────────────────────────────────────┘
```

点击 **Sync Now**，等待同步完成（底部进度条消失即可）。

---

## 7. 创建你的第一个 Activity

模板项目**没有预置 Activity**，你需要根据实验要求自行创建。

### 方式一：使用向导创建（推荐新手）

1. 在左侧 Project 面板中，**右键点击** `java` 下的包名（`cn.edu.sziit.android.tech` 或你修改后的包名）
2. 选择 **New → Activity → Empty Views Activity**
3. 在弹出的对话框中：
   - **Activity Name**：输入 Activity 名称，例如 `MainActivity`
   - **Layout Name**：会自动填充为 `activity_main`（不需要修改）
   - **Package name**：确认和你的包名一致
   - 点击 **Finish**

4. Android Studio 会自动创建：
   - `MainActivity.kt`（Kotlin 代码文件）
   - `activity_main.xml`（XML 布局文件）
   - 并自动在 `AndroidManifest.xml` 中注册

### 方式二：手动创建

如果你希望手动控制，也可以：
1. 创建一个 Kotlin 文件（Right-click → New → Kotlin Class/File）
2. 在文件中写 Activity 代码
3. 在 `AndroidManifest.xml` 中手动声明这个 Activity

`AndroidManifest.xml` 中已有注释模板，参考注释格式添加即可：

```xml
<activity
    android:name=".MainActivity"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

---

## 8. 运行到模拟器或手机

### 8.1 使用模拟器（不需要手机）

#### 创建模拟器（首次需要）

1. 点击右侧工具栏 **Device Manager**（图标像手机）
2. 点击 **+ Create Virtual Device**
3. 选择设备类型（推荐 **Pixel 6** 或 **Pixel 7**）
4. 选择系统镜像（推荐 **Android 14** `API 34` 或 **Android 15** `API 35`）
   - 如果没有下载，点击镜像旁的下载图标等待下载（约 1GB）
5. 点击 **Finish** 完成创建

#### 运行应用

1. 在顶部工具栏的设备选择下拉菜单中，选择你创建的模拟器
2. 点击绿色 **运行按钮 ▶**（或按 `Shift+F10`）
3. 等待模拟器启动和应用安装（首次可能需要 1-2 分钟）
4. 应用界面会自动显示在模拟器中

---

### 8.2 使用真实手机（可选）

#### 开启手机开发者模式

由于不同品牌手机操作略有差异，以下是通用步骤：

1. **进入"设置" → "关于手机" → "版本号"**
2. **连续快速点击"版本号" 7 次**，系统会提示"开发者模式已开启"
3. 返回"设置"，找到 **"开发者选项"**（部分手机在"关于手机"末尾或"系统"→"高级"中）
4. 开启 **"USB 调试"**

#### 连接手机

1. 用 USB 数据线将手机连接到电脑
2. 手机上会弹出提示，选择 **"允许 USB 调试"**，勾选"始终允许"并确认
3. Android Studio 顶部设备选择栏中会出现你的手机名称
4. 选择该手机，点击 **运行按钮 ▶** 即可

---

## 9. 常见问题与解决方法

### ❓ Q1：项目一直在 "Syncing" 或 "Downloading Gradle" 无法完成

**原因**：网络问题导致下载失败  
**解决方法**：
1. 检查网络连接，优先使用校园网
2. 关闭 VPN 再重试（部分 VPN 会干扰下载）
3. 在 Android Studio 中：File → Invalidate Caches → Invalidate and Restart
4. 等待重启后重新同步

---

### ❓ Q2：提示 "SDK location not found"

**原因**：`local.properties` 文件中没有设置 SDK 路径  
**解决方法**：
1. 在项目根目录找到（或创建）`local.properties` 文件
2. 确认内容格式如下（路径根据你电脑实际情况替换）：
   ```properties
   sdk.dir=C\:\\Users\\你的用户名\\AppData\\Local\\Android\\Sdk
   ```
3. 或在 Android Studio 中：File → Project Structure → SDK Location，检查 Android SDK 路径是否正确

---

### ❓ Q3：运行时提示 "INSTALL_FAILED_ALREADY_EXISTS" 或安装失败

**原因**：手机/模拟器上已安装 `applicationId` 相同的另一个应用  
**解决方法**：
1. 在手机/模拟器上，找到并**卸载**同名应用
2. 或修改 `applicationId`（参考 [6.2 修改应用 ID](#62-修改应用-id包名)）

---

### ❓ Q4：代码里 `R.layout.xxx` 报红（找不到资源）

**原因**：XML 布局文件还未创建，或文件名有误  
**解决方法**：
1. 确认 `res/layout/` 目录下存在对应的 XML 文件（如 `activity_main.xml`）
2. 检查大小写：`R.layout.activity_main` 对应文件 `activity_main.xml`（全小写+下划线）
3. 重新同步：File → Sync Project with Gradle Files

---

### ❓ Q5：修改了 `build.gradle.kts` 但不知道是否生效

**解决方法**：
- 保存文件后（`Ctrl+S`），顶部会出现 "Sync Now" 提示
- 点击 **Sync Now**，等待进度条消失，修改即生效

---

### ❓ Q6：模拟器启动非常慢

**原因**：首次启动冷启动慢，或电脑性能限制  
**解决方法**：
1. 在 BIOS 中开启 CPU 虚拟化（Intel VT-x 或 AMD-V），可显著提升模拟器速度
2. 模拟器启动后不要关闭，每次运行直接部署即可（热启动更快）
3. 如果电脑性能不足，用真实手机调试

---

*如有其他问题，请在课堂上向老师或助教寻求帮助。*  
*深圳信息职业技术学院 · Android 移动应用开发课程*
