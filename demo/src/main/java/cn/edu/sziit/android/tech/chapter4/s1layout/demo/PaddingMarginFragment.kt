package cn.edu.sziit.android.tech.chapter4.s1layout.demo

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.demo.databinding.FragmentPaddingMarginDemoBinding
import com.google.android.material.color.MaterialColors

/**
 * PaddingMarginFragment 鈥?婕旂ず android:padding 涓?android:layout_margin 鐨勫尯鍒?
 *
 * - padding锛氬唴杈硅窛锛屾帶鍒跺唴瀹逛笌鑷韩鑳屾櫙杈圭紭鐨勮窛绂伙紝鏀瑰彉瑙嗗浘鍐呴儴绌洪棿
 * - layout_margin锛氬杈硅窛锛屾帶鍒惰鍥句笌瀹瑰櫒杈圭紭/鐩搁偦瑙嗗浘鐨勮窛绂?
 */
class PaddingMarginFragment : Fragment() {

    private var _binding: FragmentPaddingMarginDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaddingMarginDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        // 鍒濆榛樿楂樹寒
        highlightPadding(8)
        highlightMargin(8)
    }

    private fun setupButtons() {
        // Padding 鎸夐挳
        binding.btnPad4.setOnClickListener { applyPadding(4) }
        binding.btnPad16.setOnClickListener { applyPadding(16) }
        binding.btnPad32.setOnClickListener { applyPadding(32) }
        // Margin 鎸夐挳
        binding.btnMar4.setOnClickListener { applyMargin(4) }
        binding.btnMar16.setOnClickListener { applyMargin(16) }
        binding.btnMar32.setOnClickListener { applyMargin(32) }
    }

    private fun applyPadding(dp: Int) {
        val px = dpToPx(dp)
        binding.tvPaddingDemo.setPadding(px, px, px, px)
        highlightPadding(dp)
    }

    private fun applyMargin(dp: Int) {
        val px = dpToPx(dp)
        val lp = binding.tvMarginDemo.layoutParams as ViewGroup.MarginLayoutParams
        lp.setMargins(px, px, px, px)
        binding.tvMarginDemo.layoutParams = lp
        highlightMargin(dp)
    }

    private fun highlightPadding(dp: Int) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        binding.codePaddingLine.text = "android:padding=\"${dp}dp\""
        binding.codePaddingLine.setTextColor(highlight)
    }

    private fun highlightMargin(dp: Int) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        binding.codeMarginLine.text = "android:layout_margin=\"${dp}dp\""
        binding.codeMarginLine.setTextColor(highlight)
    }

    private fun dpToPx(dp: Int): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
