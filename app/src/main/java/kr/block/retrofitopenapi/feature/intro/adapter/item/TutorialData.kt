package kr.block.retrofitopenapi.feature.intro.adapter.item

import androidx.annotation.DrawableRes

data class TutorialData(
    var mainTitle: String, //메인타이틀.
    var subTitle: String, //서브타이틀
    @DrawableRes
    var iconRes: Int //아이콘 리소스
)
