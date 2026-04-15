package cn.edu.sziit.android.tech.chapter4.s1layout.demo

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.demo.databinding.FragmentGravityDemoBinding
import com.google.android.material.color.MaterialColors

/**
 * GravityFragment 鈥?婕旂ず android:gravity 灞炴€у瀛愬厓绱犲榻愭柟寮忕殑褰卞搷
 *
 * gravity 浣滅敤浜庡鍣?LinearLayout锛屾帶鍒跺叾瀛愬厓绱犲湪瀹瑰櫒鍐呯殑瀵归綈浣嶇疆銆?
 */
class GravityFragment : Fragment() {

    private var _binding: FragmentGravityDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGravityDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        updateCodeHighlight("center")
    }

    private fun setupButtons() {
        binding.btnGravityCenter.setOnClickListener {
            applyGravity(Gravity.CENTER, "center")
        }
        binding.btnGravityStart.setOnClickListener {
            applyGravity(Gravity.START or Gravity.CENTER_VERTICAL, "start")
        }
        binding.btnGravityEnd.setOnClickListener {
            applyGravity(Gravity.END or Gravity.CENTER_VERTICAL, "end")
        }
        binding.btnGravityTop.setOnClickListener {
            applyGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, "top")
        }
        binding.btnGravityBottom.setOnClickListener {
            applyGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, "bottom")
        }
        binding.btnGravityCenterH.setOnClickListener {
            applyGravity(Gravity.CENTER_HORIZONTAL or Gravity.TOP, "center_horizontal")
        }
    }

    private fun applyGravity(gravity: Int, label: String) {
        binding.containerGravity.gravity = gravity
        updateCodeHighlight(label)
    }

    private fun updateCodeHighlight(value: String) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        val dimmed = MaterialColors.getColor(
            binding.root, com.google.android.material.R.attr.colorOnSurfaceVariant
        )
        binding.codeLineGravity.text = "    android:gravity=\"$value\""
        binding.codeLineGravity.setTextColor(highlight)
        listOf(binding.codeLine1, binding.codeLine2, binding.codeLine4)
            .forEach { it.setTextColor(dimmed) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
