package kr.block.retrofitopenapi.feature.main.menu.data

import android.graphics.Bitmap

data class IdentityData(
    var name:String, //이름
    var potoResource:Bitmap, //사진
    var email:String //이메일
    )
