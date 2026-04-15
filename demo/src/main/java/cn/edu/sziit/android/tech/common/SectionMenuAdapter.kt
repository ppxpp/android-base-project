package cn.edu.sziit.android.tech.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sziit.android.tech.demo.databinding.ItemSectionChildBinding
import cn.edu.sziit.android.tech.demo.databinding.ItemSectionHeaderBinding

/**
 * 棣栭〉鍒嗙粍鍒楄〃 Adapter锛歋ection Header + 鎵佸钩瀛愰」锛屾墍鏈夊唴瀹瑰缁堝彲瑙併€?
 *
 * ViewType锛?
 *  - [TYPE_HEADER]锛氱珷鑺傚垎缁勬爣棰橈紙鐏板簳灏忓瓧锛?
 *  - [TYPE_ITEM]锛氬皬鑺傚崱鐗囪锛堝彲鐐瑰嚮璺宠浆锛?
 *
 * @param groups       绔犺妭鏁版嵁鍒楄〃
 * @param onItemClick  瀛愰」鐐瑰嚮鍥炶皟
 */
class SectionMenuAdapter(
    private val groups: List<ChapterGroup>,
    private val onItemClick: (MenuEntry) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    /** 鎵佸钩鍖栧垪琛細ChapterGroup锛堝垎缁勬爣棰橈級鎴?MenuEntry锛堝瓙椤癸級 */
    private val flatList: List<Any> = buildList {
        groups.forEach { group ->
            add(group)
            addAll(group.sections)
        }
    }

    // 鈹€鈹€ ViewHolder 鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€

    class HeaderVH(val binding: ItemSectionHeaderBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ItemVH(val binding: ItemSectionChildBinding) :
        RecyclerView.ViewHolder(binding.root)

    // 鈹€鈹€ Adapter 鐢熷懡鍛ㄦ湡 鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€

    override fun getItemViewType(position: Int) =
        if (flatList[position] is ChapterGroup) TYPE_HEADER else TYPE_ITEM

    override fun getItemCount() = flatList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_HEADER) {
            HeaderVH(ItemSectionHeaderBinding.inflate(inflater, parent, false))
        } else {
            ItemVH(ItemSectionChildBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderVH -> {
                val group = flatList[position] as ChapterGroup
                holder.binding.tvSectionHeader.text = group.title
            }
            is ItemVH -> {
                val entry = flatList[position] as MenuEntry
                with(holder.binding) {
                    tvTitle.text = entry.title
                    if (entry.subtitle != null) {
                        tvSubtitle.visibility = View.VISIBLE
                        tvSubtitle.text = entry.subtitle
                    } else {
                        tvSubtitle.visibility = View.GONE
                    }
                    root.setOnClickListener { onItemClick(entry) }
                }
            }
        }
    }
}
