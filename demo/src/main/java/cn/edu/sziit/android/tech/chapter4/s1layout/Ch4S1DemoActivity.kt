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
 * 4.1 路 Activity 甯冨眬 鈥?鏁堟灉婕旂ず瀹瑰櫒
 *
 * 閫氳繃 Intent Extra [EXTRA_FRAGMENT_TAG] 鍐冲畾鏄剧ず鍝釜婕旂ず Fragment銆?
 * 鏂板婕旂ず鏃讹細鏂板缓 Fragment 鈫?鍦ㄦ湰绫绘敞鍐?TAG 甯搁噺 鈫?鍦?[Ch4S1Activity] 杩藉姞鍒楄〃椤广€?
 */
class Ch4S1DemoActivity : AppCompatActivity() {

    companion object {
        /** Intent Extra key锛氭寚瀹氳鏄剧ず鐨?Fragment tag */
        const val EXTRA_FRAGMENT_TAG = "fragment_tag"

        const val TAG_VISIBILITY    = "visibility"
        const val TAG_GRAVITY        = "gravity"
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

        // 鏍规嵁 Extra 鍔犺浇瀵瑰簲 Fragment锛堜粎棣栨鍒涘缓鏃舵坊鍔狅紝閬垮厤鏃嬭浆灞忓箷閲嶅娣诲姞锛?
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
            // 鏇存柊 Toolbar 鏍囬
            binding.toolbar.title = getTitleForTag(tag)

            supportFragmentManager.beginTransaction()
                .replace(cn.edu.sziit.android.tech.demo.R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    private fun getTitleForTag(tag: String): String = when (tag) {
        TAG_VISIBILITY    -> "visibility 婕旂ず"
        TAG_GRAVITY       -> "gravity 婕旂ず"
        TAG_PADDING_MARGIN -> "padding / margin 婕旂ず"
        TAG_LAYOUT_SIZE  -> "layout_width / height 婕旂ず"
        TAG_ORIENTATION  -> "orientation 婕旂ず"
        TAG_CONSTRAINT   -> "ConstraintLayout 绾︽潫婕旂ず"
        else             -> "鏁堟灉婕旂ず"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}


