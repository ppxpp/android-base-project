package cn.edu.sziit.android.tech.chapter4.s1layout.demo

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.demo.databinding.FragmentLayoutSizeDemoBinding
import com.google.android.material.color.MaterialColors

/**
 * LayoutSizeFragment 鈥?婕旂ず android:layout_width 鍜?android:layout_height 鐨勪笁绉嶅彇鍊?
 *
 * - wrap_content锛氳鍥惧昂瀵哥敱鍐呭鍐冲畾
 * - match_parent锛氳鍥惧昂瀵告拺婊＄埗瀹瑰櫒
 * - 鍥哄畾 dp 鍊硷細瑙嗗浘灏哄鍥哄畾涓嶅彉
 */
class LayoutSizeFragment : Fragment() {

    private var _binding: FragmentLayoutSizeDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLayoutSizeDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        updateWidthCode("wrap_content")
        updateHeightCode("wrap_content")
    }

    private fun setupButtons() {
        // Width 鎸夐挳
        binding.btnWrapContent.setOnClickListener { applyWidth(ViewGroup.LayoutParams.WRAP_CONTENT, "wrap_content") }
        binding.btnMatchParent.setOnClickListener { applyWidth(ViewGroup.LayoutParams.MATCH_PARENT, "match_parent") }
        binding.btn120dp.setOnClickListener { applyWidth(dpToPx(120), "120dp") }

        // Height 鎸夐挳
        binding.btnHeightWrap.setOnClickListener { applyHeight(ViewGroup.LayoutParams.WRAP_CONTENT, "wrap_content") }
        binding.btnHeightMatch.setOnClickListener { applyHeight(ViewGroup.LayoutParams.MATCH_PARENT, "match_parent") }
        binding.btnHeight80dp.setOnClickListener { applyHeight(dpToPx(80), "80dp") }
    }

    private fun applyWidth(widthPx: Int, label: String) {
        val lp = binding.tvWidthDemo.layoutParams
        lp.width = widthPx
        binding.tvWidthDemo.layoutParams = lp
        updateWidthCode(label)
    }

    private fun applyHeight(heightPx: Int, label: String) {
        val lp = binding.tvHeightDemo.layoutParams
        lp.height = heightPx
        binding.tvHeightDemo.layoutParams = lp
        updateHeightCode(label)
    }

    private fun updateWidthCode(label: String) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        binding.codeLineWidth.text = "android:layout_width=\"$label\""
        binding.codeLineWidth.setTextColor(highlight)
    }

    private fun updateHeightCode(label: String) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        binding.codeLineHeight.text = "android:layout_height=\"$label\""
        binding.codeLineHeight.setTextColor(highlight)
    }

    private fun dpToPx(dp: Int): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
