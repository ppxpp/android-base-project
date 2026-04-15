package cn.edu.sziit.android.tech.chapter4.s1layout.demo

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import cn.edu.sziit.android.tech.demo.R
import cn.edu.sziit.android.tech.demo.databinding.FragmentConstraintDemoBinding
import com.google.android.material.color.MaterialColors

class ConstraintFragment : Fragment() {

    private var _binding: FragmentConstraintDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConstraintDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        updateCode(configTriangleCode())
    }

    private fun setupButtons() {
        binding.btnTriangle.setOnClickListener { applyTriangle() }
        binding.btnAllCenter.setOnClickListener { applyAllCenter() }
        binding.btnHChain.setOnClickListener { applyHChain() }
        binding.btnRelative.setOnClickListener { applyRelative() }
    }

    private fun applyTriangle() {
        val m = dpToPx(16)
        val cs = ConstraintSet().apply {
            clone(binding.containerConstraint)
            clearAllConstraints(R.id.tvConA)
            connect(R.id.tvConA, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, m)
            connect(R.id.tvConA, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, m)
            setMargin(R.id.tvConA, ConstraintSet.START, 0)
            setMargin(R.id.tvConA, ConstraintSet.TOP, 0)
            clearAllConstraints(R.id.tvConB)
            connect(R.id.tvConB, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, m)
            connect(R.id.tvConB, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(R.id.tvConB, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            setMargin(R.id.tvConB, ConstraintSet.END, 0)
            setMargin(R.id.tvConB, ConstraintSet.TOP, 0)
            setMargin(R.id.tvConB, ConstraintSet.BOTTOM, 0)
            clearAllConstraints(R.id.tvConC)
            connect(R.id.tvConC, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, m)
            connect(R.id.tvConC, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, m)
            setMargin(R.id.tvConC, ConstraintSet.START, 0)
            setMargin(R.id.tvConC, ConstraintSet.BOTTOM, 0)
        }
        cs.applyTo(binding.containerConstraint)
        updateCode(configTriangleCode())
    }

    private fun applyAllCenter() {
        val cs = ConstraintSet().apply {
            clone(binding.containerConstraint)
            listOf(R.id.tvConA, R.id.tvConB, R.id.tvConC).forEach { id ->
                clearAllConstraints(id)
                connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
                connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
                connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
                setMargin(id, ConstraintSet.START, 0)
                setMargin(id, ConstraintSet.END, 0)
                setMargin(id, ConstraintSet.TOP, 0)
                setMargin(id, ConstraintSet.BOTTOM, 0)
            }
        }
        cs.applyTo(binding.containerConstraint)
        updateCode(configCenterCode())
    }

    private fun applyHChain() {
        val cs = ConstraintSet().apply {
            clone(binding.containerConstraint)
            listOf(R.id.tvConA, R.id.tvConB, R.id.tvConC).forEach { clearAllConstraints(it) }
            connect(R.id.tvConA, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.tvConA, ConstraintSet.END, R.id.tvConB, ConstraintSet.START)
            connect(R.id.tvConA, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(R.id.tvConA, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            connect(R.id.tvConB, ConstraintSet.START, R.id.tvConA, ConstraintSet.END)
            connect(R.id.tvConB, ConstraintSet.END, R.id.tvConC, ConstraintSet.START)
            connect(R.id.tvConB, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(R.id.tvConB, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            connect(R.id.tvConC, ConstraintSet.START, R.id.tvConB, ConstraintSet.END)
            connect(R.id.tvConC, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(R.id.tvConC, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(R.id.tvConC, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            setHorizontalChainStyle(R.id.tvConA, ConstraintSet.CHAIN_SPREAD)
            listOf(R.id.tvConA, R.id.tvConB, R.id.tvConC).forEach { id ->
                listOf(ConstraintSet.START, ConstraintSet.END, ConstraintSet.TOP, ConstraintSet.BOTTOM)
                    .forEach { dir -> setMargin(id, dir, 0) }
            }
        }
        cs.applyTo(binding.containerConstraint)
        updateCode(configHChainCode())
    }

    private fun applyRelative() {
        val m = dpToPx(8)
        val cs = ConstraintSet().apply {
            clone(binding.containerConstraint)
            clearAllConstraints(R.id.tvConA)
            connect(R.id.tvConA, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.tvConA, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(R.id.tvConA, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, dpToPx(16))
            setMargin(R.id.tvConA, ConstraintSet.TOP, 0)
            clearAllConstraints(R.id.tvConB)
            connect(R.id.tvConB, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.tvConB, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(R.id.tvConB, ConstraintSet.TOP, R.id.tvConA, ConstraintSet.BOTTOM, m)
            setMargin(R.id.tvConB, ConstraintSet.TOP, 0)
            clearAllConstraints(R.id.tvConC)
            connect(R.id.tvConC, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.tvConC, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(R.id.tvConC, ConstraintSet.TOP, R.id.tvConB, ConstraintSet.BOTTOM, m)
            setMargin(R.id.tvConC, ConstraintSet.TOP, 0)
            listOf(R.id.tvConA, R.id.tvConB, R.id.tvConC).forEach { id ->
                setMargin(id, ConstraintSet.START, 0)
                setMargin(id, ConstraintSet.END, 0)
            }
        }
        cs.applyTo(binding.containerConstraint)
        updateCode(configRelativeCode())
    }

    private fun ConstraintSet.clearAllConstraints(id: Int) {
        clear(id, ConstraintSet.START)
        clear(id, ConstraintSet.END)
        clear(id, ConstraintSet.TOP)
        clear(id, ConstraintSet.BOTTOM)
    }

    private fun updateCode(text: String) {
        val highlight = MaterialColors.getColor(binding.root, androidx.appcompat.R.attr.colorPrimary)
        val lines = text.lines()
        binding.codeConstraintA.text = lines.getOrElse(0) { "" }
        binding.codeConstraintB.text = lines.getOrElse(1) { "" }
        binding.codeConstraintC.text = lines.getOrElse(2) { "" }
        listOf(binding.codeConstraintA, binding.codeConstraintB, binding.codeConstraintC)
            .forEach { it.setTextColor(highlight) }
    }

    private fun configTriangleCode() =
        "A: start+top of parent\nB: end | center_vertical\nC: start+bottom of parent"

    private fun configCenterCode() =
        "A/B/C: start+end+top+bottom\n-> center in parent\n(views overlapping)"

    private fun configHChainCode() =
        "A: start->parent, end->B\nB: start->A, end->C  [chain]\nC: start->B, end->parent"

    private fun configRelativeCode() =
        "A: center_h, top of parent\nB: top_toBottomOf A (8dp)\nC: top_toBottomOf B (8dp)"

    private fun dpToPx(dp: Int): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}