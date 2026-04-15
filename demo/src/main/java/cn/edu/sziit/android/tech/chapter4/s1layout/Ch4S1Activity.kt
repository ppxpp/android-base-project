package cn.edu.sziit.android.tech.chapter4.s1layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.sziit.android.tech.common.MenuEntry
import cn.edu.sziit.android.tech.common.MenuEntryAdapter
import cn.edu.sziit.android.tech.demo.databinding.ActivityCh4S1Binding

class Ch4S1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCh4S1Binding

    private val entries = listOf(
        MenuEntry(
            title = "Lab",
            subtitle = "Complete the lab exercise here",
            action = "cn.edu.sziit.android.tech.lab.CH4_S1"
        ),
        MenuEntry(
            title = "visibility Demo",
            subtitle = "VISIBLE / INVISIBLE / GONE",
            target = Ch4S1DemoActivity::class.java,
            extras = mapOf(Ch4S1DemoActivity.EXTRA_FRAGMENT_TAG to Ch4S1DemoActivity.TAG_VISIBILITY)
        ),
        MenuEntry(
            title = "gravity Demo",
            subtitle = "Alignment direction inside container",
            target = Ch4S1DemoActivity::class.java,
            extras = mapOf(Ch4S1DemoActivity.EXTRA_FRAGMENT_TAG to Ch4S1DemoActivity.TAG_GRAVITY)
        ),
        MenuEntry(
            title = "padding / margin Demo",
            subtitle = "Visual difference between inner and outer spacing",
            target = Ch4S1DemoActivity::class.java,
            extras = mapOf(Ch4S1DemoActivity.EXTRA_FRAGMENT_TAG to Ch4S1DemoActivity.TAG_PADDING_MARGIN)
        ),
        MenuEntry(
            title = "layout_width / height Demo",
            subtitle = "wrap_content, match_parent, fixed size",
            target = Ch4S1DemoActivity::class.java,
            extras = mapOf(Ch4S1DemoActivity.EXTRA_FRAGMENT_TAG to Ch4S1DemoActivity.TAG_LAYOUT_SIZE)
        ),
        MenuEntry(
            title = "orientation Demo",
            subtitle = "LinearLayout horizontal vs vertical",
            target = Ch4S1DemoActivity::class.java,
            extras = mapOf(Ch4S1DemoActivity.EXTRA_FRAGMENT_TAG to Ch4S1DemoActivity.TAG_ORIENTATION)
        ),
        MenuEntry(
            title = "ConstraintLayout Demo",
            subtitle = "Switch constraint configs to observe layout changes",
            target = Ch4S1DemoActivity::class.java,
            extras = mapOf(Ch4S1DemoActivity.EXTRA_FRAGMENT_TAG to Ch4S1DemoActivity.TAG_CONSTRAINT)
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4S1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.rvEntries.layoutManager = LinearLayoutManager(this)
        binding.rvEntries.adapter = MenuEntryAdapter(entries) { entry ->
            val intent = if (entry.action != null) {
                android.content.Intent(entry.action)
            } else {
                android.content.Intent(this, entry.target)
            }
            entry.extras.forEach { (k, v) -> intent.putExtra(k, v) }
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}