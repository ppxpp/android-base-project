package cn.edu.sziit.android.tech.chapter4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.sziit.android.tech.chapter4.s1layout.Ch4S1Activity
import cn.edu.sziit.android.tech.common.MenuEntry
import cn.edu.sziit.android.tech.common.MenuEntryAdapter
import cn.edu.sziit.android.tech.demo.databinding.ActivityCh4Binding

class Ch4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCh4Binding

    private val sections = listOf(
        MenuEntry(
            title = "4.1 \u00b7 Activity \u5e03\u5c40",
            subtitle = "\u5e03\u5c40\u6587\u4ef6\u7ed3\u6784\u4e0e ViewBinding \u4f7f\u7528",
            target = Ch4S1Activity::class.java
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
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
