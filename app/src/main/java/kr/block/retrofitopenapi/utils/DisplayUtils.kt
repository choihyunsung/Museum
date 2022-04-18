package kr.block.retrofitopenapi.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.TypedValue

object DisplayUtils {
    /**
     * Dp를 Px로 변환.
     */
    fun dpToPx(context: Context, dp: Float): Float =
        TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics,
    )
    /**
     * px를 Dp로 변환.
     */
    fun pxToDp(context: Context, px: Int): Int =
        (px / context.resources.displayMetrics.density).toInt()

    /**
     * displaySize 반환 Pair First  -> width  Second -> height
     */
    fun displaySize(context: Activity): Pair<Int, Int> = Pair(
        context.resources.displayMetrics.widthPixels,
        context.resources.displayMetrics.heightPixels
    )

}