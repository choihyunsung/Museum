package kr.block.retrofitopenapi.feature.main.localtech.adapter.item

import androidx.annotation.DrawableRes
import kr.block.retrofitopenapi.feature.main.localtech.fragment.LocalTechnologyFragment
import kr.block.retrofitopenapi.feature.main.localtech.fragment.LocalTechnologyFragment.*

data class LocalTechnologyData(
    var Techtype: LocalTechType, //기술명
    @DrawableRes
    var icon:Int, //아이콘 이미지
    var backColor:String, //백그라운드 컬러.
    var content:String //설명 내용.
    )
