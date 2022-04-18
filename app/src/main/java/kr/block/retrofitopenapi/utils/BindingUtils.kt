package kr.block.retrofitopenapi.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingUtils {
    @BindingAdapter("bind:src")
    @JvmStatic
    fun setSrc(iv: ImageView, res: Int) {
        iv.setImageResource(res)
    }
}