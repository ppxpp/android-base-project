package cn.edu.sziit.android.tech.chapter4.s1layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.chapter4.s1layout.demo.ConstraintFragment
import cn.edu.sziit.android.tech.chapter4.s1layout.demo.GravityFragment
import cn.edu.sziit.android.tech.chapter4.s1layout.demo.LayoutSizeFragment
import cn.edu.sziit.android.tech.chapter4.s1layout.demo.OrientationFragment
import cn.edu.sziit.android.tech.chapter4.s1layout.demo.PaddingMarginFragment
import cn.edu.sziit.android.tech.chapter4.s1layout.demo.VisibilityFragment
import cn.edu.sziit.android.tech.demo.databinding.ActivityCh4S1DemoBinding

/**
 * 4.1 - Activity Layout - Demo Container
 *
 * Reads EXTRA_FRAGMENT_TAG from Intent to decide which Fragment to show.
 * To add a new demo: create Fragment -> add TAG constant here -> add entry in Ch4S1Activity.
 */
class Ch4S1DemoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FRAGMENT_TAG = "fragment_tag"

        const val TAG_VISIBILITY    = "visibility"
        const val TAG_GRAVITY       = "gravity"
        const val TAG_PADDING_MARGIN = "padding_margin"
        const val TAG_LAYOUT_SIZE   = "layout_size"
        const val TAG_ORIENTATION   = "orientation"
        const val TAG_CONSTRAINT    = "constraint"
    }

    private lateinit var binding: ActivityCh4S1DemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh4S1DemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val tag = intent.getStringExtra(EXTRA_FRAGMENT_TAG) ?: TAG_VISIBILITY
            val fragment: Fragment = when (tag) {
                TAG_VISIBILITY    -> VisibilityFragment()
                TAG_GRAVITY       -> GravityFragment()
                TAG_PADDING_MARGIN -> PaddingMarginFragment()
                TAG_LAYOUT_SIZE  -> LayoutSizeFragment()
                TAG_ORIENTATION  -> OrientationFragment()
                TAG_CONSTRAINT   -> ConstraintFragment()
                else             -> VisibilityFragment()
            }
            binding.toolbar.title = getTitleForTag(tag)
            supportFragmentManager.beginTransaction()
                .replace(cn.edu.sziit.android.tech.demo.R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    private fun getTitleForTag(tag: String): String = when (tag) {
        TAG_VISIBILITY    -> "visibility \u6f14\u793a"
        TAG_GRAVITY       -> "gravity \u6f14\u793a"
        TAG_PADDING_MARGIN -> "padding / margin \u6f14\u793a"
        TAG_LAYOUT_SIZE  -> "layout_width / height \u6f14\u793a"
        TAG_ORIENTATION  -> "orientation \u6f14\u793a"
        TAG_CONSTRAINT   -> "ConstraintLayout \u7ea6\u675f\u6f14\u793a"
        else             -> "\u6548\u679c\u6f14\u793a"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}