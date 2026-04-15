package cn.edu.sziit.android.tech.chapter4.s1layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sziit.android.tech.databinding.ActivityCh4S1LinearLabBinding

/**
 * 4.1 · 线性布局实验页
 *
 * 学生在 [activity_ch4_s1_linear_lab.xml] 的 `labContainer`（LinearLayout）
 * 内添加视图，练习 LinearLayout 相关属性。
 */
class Ch4S1LinearLabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCh4S1LinearLabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4S1LinearLabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
