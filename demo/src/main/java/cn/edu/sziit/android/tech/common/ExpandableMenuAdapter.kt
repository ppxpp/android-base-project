package cn.edu.sziit.android.tech.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sziit.android.tech.demo.databinding.ItemChapterGroupBinding
import cn.edu.sziit.android.tech.demo.databinding.ItemSectionChildBinding

/**
 * MainActivity 鍙睍寮€绔犺妭鍒楄〃 Adapter銆?
 *
 * 鏀寔涓ょ ViewType锛?
 *  - [TYPE_GROUP]锛氱珷鑺傜粍鏍囬琛岋紙鐐瑰嚮灞曞紑/鎶樺彔锛?
 *  - [TYPE_CHILD]锛氬皬鑺傚瓙椤硅锛堢偣鍑昏烦杞洰鏍?Activity锛?
 *
 * @param groups   绔犺妭缁勫垪琛?
 * @param onChildClick 瀛愰」鐐瑰嚮鍥炶皟锛屽弬鏁颁负鐐瑰嚮鐨?[MenuEntry]
 */
class ExpandableMenuAdapter(
    private val groups: List<ChapterGroup>,
    private val onChildClick: (MenuEntry) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_GROUP = 0
        private const val TYPE_CHILD = 1
    }

    /** 璁板綍姣忎釜 group 鏄惁灞曞紑 */
    private val expandedState = BooleanArray(groups.size) { false }

    /** 鎵佸钩鍖栫殑鏄剧ず椤瑰垪琛紙鐢?groups + expandedState 鍔ㄦ€佽绠楋級 */
    private val flatItems = mutableListOf<Any>() // ChapterGroup 鎴?MenuEntry

    init {
        refreshFlatItems()
    }

    private fun refreshFlatItems() {
        flatItems.clear()
        groups.forEachIndexed { index, group ->
            flatItems.add(group)
            if (expandedState[index]) {
                flatItems.addAll(group.sections)
            }
        }
    }

    // 鈹€鈹€ ViewHolder 鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€

    inner class GroupVH(val binding: ItemChapterGroupBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ChildVH(val binding: ItemSectionChildBinding) :
        RecyclerView.ViewHolder(binding.root)

    // 鈹€鈹€ Adapter 鐢熷懡鍛ㄦ湡 鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€鈹€

    override fun getItemViewType(position: Int) =
        if (flatItems[position] is ChapterGroup) TYPE_GROUP else TYPE_CHILD

    override fun getItemCount() = flatItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_GROUP) {
            GroupVH(ItemChapterGroupBinding.inflate(inflater, parent, false))
        } else {
            ChildVH(ItemSectionChildBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GroupVH -> bindGroup(holder, position)
            is ChildVH -> bindChild(holder, position)
        }
    }

    private fun bindGroup(holder: GroupVH, position: Int) {
        val group = flatItems[position] as ChapterGroup
        val groupIndex = groups.indexOf(group)
        val isExpanded = expandedState[groupIndex]

        with(holder.binding) {
            tvGroupTitle.text = group.title
            // 绠ご鏃嬭浆锛氬睍寮€鏃跺悜涓嬶紝鎶樺彔鏃跺悜鍙?
            ivGroupArrow.rotation = if (isExpanded) 90f else 0f

            root.setOnClickListener {
                toggleGroup(groupIndex)
            }
        }
    }

    private fun bindChild(holder: ChildVH, position: Int) {
        val entry = flatItems[position] as MenuEntry
        with(holder.binding) {
            tvTitle.text = entry.title
            if (entry.subtitle != null) {
                tvSubtitle.visibility = View.VISIBLE
                tvSubtitle.text = entry.subtitle
            } else {
                tvSubtitle.visibility = View.GONE
            }
            root.setOnClickListener { onChildClick(entry) }
        }
    }

    private fun toggleGroup(groupIndex: Int) {
        val wasExpanded = expandedState[groupIndex]
        expandedState[groupIndex] = !wasExpanded

        // 閲嶆柊璁＄畻鎵佸钩鍒楄〃骞跺仛灞€閮ㄥ埛鏂板姩鐢?
        val group = groups[groupIndex]
        val groupFlatPos = flatItems.indexOfFirst { it is ChapterGroup && it == group }

        refreshFlatItems()

        if (wasExpanded) {
            // 鎶樺彔锛氱Щ闄ゅ瓙椤?
            notifyItemRangeRemoved(groupFlatPos + 1, group.sections.size)
        } else {
            // 灞曞紑锛氭彃鍏ュ瓙椤?
            notifyItemRangeInserted(groupFlatPos + 1, group.sections.size)
        }
        // 鍒锋柊缁勫ご锛堢澶存棆杞級
        notifyItemChanged(groupFlatPos)
    }
}
