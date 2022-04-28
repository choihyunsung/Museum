package kr.block.retrofitopenapi.feature.main.networktech.adapter.item

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import kr.block.retrofitopenapi.feature.main.networktech.fragment.NetworkTechnologyFragment

data class NetworkTechnologyData(
    @DrawableRes
    var icon: Int, //아이콘
    var title: String, //타이틀
    var apiType: NetworkTechnologyFragment.RestApiType //Api 타입.
)