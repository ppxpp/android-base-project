package cn.edu.sziit.android.tech.chapter4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.sziit.android.tech.chapter4.s1layout.Ch4S1Activity
import cn.edu.sziit.android.tech.common.MenuEntry
import cn.edu.sziit.android.tech.common.MenuEntryAdapter
import cn.edu.sziit.android.tech.demo.databinding.ActivityCh4Binding

/**
 * 绗?绔犲叆鍙?鈥?鏄剧ず鏈珷鎵€鏈夊皬鑺傚垪琛ㄣ€?
 * 鏂板灏忚妭鏃讹紝鍙渶鍦?[sections] 涓拷鍔犱竴鏉?[MenuEntry]銆?
 */
class Ch4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCh4Binding

    /** 灏忚妭鍒楄〃鏁版嵁锛氭柊澧炲皬鑺傚彧闇€杩藉姞涓€鏉?*/
    private val sections = listOf(
        MenuEntry(
            title = "4.1 路 Activity 甯冨眬",
            subtitle = "甯冨眬鏂囦欢缁撴瀯涓?ViewBinding 浣跨敤",
            target = Ch4S1Activity::class.java
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        // 鍚敤鏍囬鏍忚繑鍥為敭
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.rvSections.layoutManager = LinearLayoutManager(this)
        binding.rvSections.adapter = MenuEntryAdapter(sections) { entry ->
            startActivity(Intent(this, entry.target))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
