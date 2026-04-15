package cn.edu.sziit.android.tech.chapter4.s1layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sziit.android.tech.databinding.ActivityCh4S1LabBinding

/**
 * 4.1 · Activity 布局 — 实验框架页
 * 学生在此完成布局相关实验练习。
 */
class Ch4S1LabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCh4S1LabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4S1LabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
