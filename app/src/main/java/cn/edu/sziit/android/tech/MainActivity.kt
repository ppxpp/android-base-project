package cn.edu.sziit.android.tech

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.sziit.android.tech.chapter4.s1layout.Ch4S1Activity
import cn.edu.sziit.android.tech.common.ChapterGroup
import cn.edu.sziit.android.tech.common.ExpandableMenuAdapter
import cn.edu.sziit.android.tech.common.MenuEntry
import cn.edu.sziit.android.tech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * 课程目录数据：ChapterGroup（章节）包含 sections（小节列表）。
     * 新增章节 → 追加一个 ChapterGroup
     * 新增小节 → 在对应 ChapterGroup.sections 中追加 MenuEntry
     */
    private val chapters = listOf(
        ChapterGroup(
            title = "第4章 · Android 组件",
            sections = listOf(
                MenuEntry(
                    title = "4.1 · Activity 布局",
                    subtitle = "布局文件结构与 ViewBinding 使用",
                    target = Ch4S1Activity::class.java
                )
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.rvChapters.layoutManager = LinearLayoutManager(this)
        binding.rvChapters.adapter = ExpandableMenuAdapter(chapters) { entry ->
            startActivity(Intent(this, entry.target ?: return@ExpandableMenuAdapter))
        }
    }
}
