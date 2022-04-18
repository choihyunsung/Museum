package kr.block.retrofitopenapi.utils

import android.content.Context
import android.util.TypedValue

class DisplayUtils(val context: Context) {
    companion object {
        @Volatile
        private var INSTANCE: DisplayUtils? = null

        fun getInstance(context: Context): DisplayUtils = INSTANCE ?: synchronized(this) {
            INSTANCE ?: DisplayUtils(context).also { INSTANCE = it }
        }

        fun dpToPx(dp: Float): Float = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            INSTANCE?.context!!.resources.displayMetrics,
        )

        fun pxToDp(px: Int):Int = (px/ INSTANCE?.context!!.resources.displayMetrics.density).toInt()

    }
}