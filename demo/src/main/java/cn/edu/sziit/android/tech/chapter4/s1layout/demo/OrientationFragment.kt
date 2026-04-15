package cn.edu.sziit.android.tech.chapter4.s1layout.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.demo.databinding.FragmentOrientationDemoBinding
import com.google.android.material.color.MaterialColors

/**
 * OrientationFragment 鈥?婕旂ず LinearLayout 鐨?android:orientation 灞炴€?
 *
 * - HORIZONTAL锛氬瓙鍏冪礌姘村钩鎺掑垪锛堥粯璁ゆ柟鍚戯級
 * - VERTICAL  锛氬瓙鍏冪礌鍨傜洿鍫嗗彔
 */
class OrientationFragment : Fragment() {

    private var _binding: FragmentOrientationDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrientationDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        updateCodeHighlight("horizontal")
    }

    private fun setupButtons() {
        binding.btnHorizontal.setOnClickListener {
            binding.containerOrientation.orientation = LinearLayout.HORIZONTAL
            updateCodeHighlight("horizontal")
        }
        binding.btnVertical.setOnClickListener {
            binding.containerOrientation.orientation = LinearLayout.VERTICAL
            updateCodeHighlight("vertical")
        }
    }

    private fun updateCodeHighlight(value: String) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        val dimmed = MaterialColors.getColor(
            binding.root, com.google.android.material.R.attr.colorOnSurfaceVariant
        )
        binding.codeLineOrientation.text = "    android:orientation=\"$value\""
        binding.codeLineOrientation.setTextColor(highlight)
        listOf(binding.codeLine1, binding.codeLine3).forEach { it.setTextColor(dimmed) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
