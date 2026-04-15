package cn.edu.sziit.android.tech.chapter4.s1layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sziit.android.tech.databinding.ActivityCh4S1ConstraintLabBinding

/**
 * 4.1 · 约束布局实验页
 *
 * 学生在 [activity_ch4_s1_constraint_lab.xml] 的 `labContainer`（ConstraintLayout）
 * 内添加视图并设置约束关系，练习 ConstraintLayout 相关属性。
 */
class Ch4S1ConstraintLabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCh4S1ConstraintLabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4S1ConstraintLabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
