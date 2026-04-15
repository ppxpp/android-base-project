package cn.edu.sziit.android.tech.chapter4.s1layout.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.demo.databinding.FragmentVisibilityDemoBinding
import com.google.android.material.color.MaterialColors

/**
 * VisibilityFragment 鈥?婕旂ず android:visibility 灞炴€х殑涓夌鍙栧€兼晥鏋?
 *
 * - VISIBLE    锛歏iew 鍙锛屽崰鎹竷灞€绌洪棿
 * - INVISIBLE  锛歏iew 涓嶅彲瑙侊紝浣嗕粛鍗犳嵁甯冨眬绌洪棿锛圴iew C 浣嶇疆涓嶅彉锛?
 * - GONE       锛歏iew 涓嶅彲瑙侊紝涓斾笉鍗犳嵁甯冨眬绌洪棿锛圴iew C 鑷姩宸︾Щ锛?
 */
class VisibilityFragment : Fragment() {

    private var _binding: FragmentVisibilityDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVisibilityDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        // 榛樿鏄剧ず VISIBLE 鐘舵€侀珮浜?
        updateCodeHighlight("visible")
    }

    // 鈹€鈹€ 鎸夐挳浜嬩欢 鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€

    private fun setupButtons() {
        binding.btnVisible.setOnClickListener {
            binding.viewB.visibility = View.VISIBLE
            updateCodeHighlight("visible")
        }
        binding.btnInvisible.setOnClickListener {
            binding.viewB.visibility = View.INVISIBLE
            updateCodeHighlight("invisible")
        }
        binding.btnGone.setOnClickListener {
            binding.viewB.visibility = View.GONE
            updateCodeHighlight("gone")
        }
    }

    // 鈹€鈹€ 浠ｇ爜楂樹寒 鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€

    /**
     * 鏇存柊浠ｇ爜鐗囨灞曠ず鍖猴細楂樹寒 visibility 鍙栧€奸偅涓€琛岋紝鍏朵綑琛岀疆鐏?
     */
    private fun updateCodeHighlight(value: String) {
        // 楂樹寒鑹?= 涓婚 colorPrimary
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        // 鏅€氳壊 = colorOnSurfaceVariant
        val dimmed = MaterialColors.getColor(
            binding.root,
            com.google.android.material.R.attr.colorOnSurfaceVariant
        )

        // 鏇存柊 visibility 楂樹寒琛屾枃瀛?
        binding.codeLineVisibility.text = "    android:visibility=\"$value\""
        binding.codeLineVisibility.setTextColor(highlight)

        // 鍏朵綑 4 琛岀疆鐏?
        listOf(
            binding.codeLine1,
            binding.codeLine2,
            binding.codeLine3,
            binding.codeLine5
        ).forEach { it.setTextColor(dimmed) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
