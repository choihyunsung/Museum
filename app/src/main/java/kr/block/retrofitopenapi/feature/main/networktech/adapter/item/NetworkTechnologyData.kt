package kr.block.retrofitopenapi.feature.main.networktech.adapter.item

import androidx.annotation.LayoutRes

data class NetworkTechnologyData(
    @LayoutRes
    var icon: Int, //아이콘
    var title: String, //타이틀
)