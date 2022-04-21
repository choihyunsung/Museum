package kr.block.retrofitopenapi.feature.main.localtech.adapter.item

import androidx.annotation.DrawableRes

data class LocalTechnologyData(
    var name:String, //기술명
    @DrawableRes
    var icon:Int, //아이콘 이미지
    var backColor:String, //백그라운드 컬러.
    var content:String //설명 내용.
    )
