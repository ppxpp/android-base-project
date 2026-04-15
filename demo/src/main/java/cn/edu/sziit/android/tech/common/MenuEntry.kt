package cn.edu.sziit.android.tech.common

import android.app.Activity

/**
 * 鑿滃崟鍒楄〃椤规暟鎹ā鍨嬶紝渚涚珷鑺傚睍寮€瀛愰」鍙婁簩绾ц彍鍗曢〉澶嶇敤銆?
 *
 * @param title    鍒楄〃椤逛富鏍囬锛堝繀濉級
 * @param subtitle 鍒楄〃椤瑰壇鏍囬锛屼负 null 鏃堕殣钘忥紙鍙€夛級
 * @param target   鐐瑰嚮鍚庤烦杞殑 Activity Class锛堝悓妯″潡鍐呯洿鎺ヨ烦杞級
 * @param action   鐐瑰嚮鍚庡彂閫佺殑闅愬紡 Intent Action锛堣法妯″潡瑙ｈ€﹀悎璺宠浆锛屽瀹為獙妗嗘灦锛?
 * @param extras   璺宠浆鏃舵惡甯︾殑棰濆鍙傛暟锛坘ey-value锛夛紝濡?Fragment tag
 *
 * [target] 鍜?[action] 鑷冲皯濉叾涓€銆?
 */
data class MenuEntry(
    val title: String,
    val subtitle: String? = null,
    val target: Class<out Activity>? = null,
    val action: String? = null,
    val extras: Map<String, String> = emptyMap()
)

/**
 * 绔犺妭缁勬暟鎹ā鍨嬶紝鐢ㄤ簬 MainActivity 鍙睍寮€鍒楄〃銆?
 *
 * @param title    绔犺妭鏍囬锛屽"绗?绔?路 Android 缁勪欢"
 * @param sections 绔犺妭涓嬬殑灏忚妭鍒楄〃
 */
data class ChapterGroup(
    val title: String,
    val sections: List<MenuEntry>
)
