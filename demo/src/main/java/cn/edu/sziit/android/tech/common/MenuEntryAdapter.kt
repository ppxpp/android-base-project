package cn.edu.sziit.android.tech.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sziit.android.tech.demo.databinding.ItemMenuEntryBinding

/**
 * 閫氱敤鑿滃崟鍒楄〃 Adapter锛屼緵鎵€鏈夌珷鑺?灏忚妭鑿滃崟椤靛鐢ㄣ€?
 *
 * @param items   鍒楄〃鏁版嵁
 * @param onClick 鐐瑰嚮鍥炶皟锛屽弬鏁颁负鐐瑰嚮鐨?[MenuEntry]
 */
class MenuEntryAdapter(
    private val items: List<MenuEntry>,
    private val onClick: (MenuEntry) -> Unit
) : RecyclerView.Adapter<MenuEntryAdapter.VH>() {

    inner class VH(val binding: ItemMenuEntryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemMenuEntryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val entry = items[position]
        with(holder.binding) {
            tvTitle.text = entry.title
            if (entry.subtitle != null) {
                tvSubtitle.visibility = View.VISIBLE
                tvSubtitle.text = entry.subtitle
            } else {
                tvSubtitle.visibility = View.GONE
            }
            root.setOnClickListener { onClick(entry) }
        }
    }
}
