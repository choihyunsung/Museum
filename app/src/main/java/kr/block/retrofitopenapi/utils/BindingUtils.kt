package kr.block.retrofitopenapi.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView

object BindingUtils {
    @BindingAdapter("bind:src")
    @JvmStatic
    fun setSrc(iv: ImageView, res: Int) {
        iv.setImageResource(res)
    }

    @BindingAdapter("bind:srcDrawable")
    @JvmStatic
    fun setSrcDrawable(iv: ImageView, drawable: Drawable) {
        iv.setImageDrawable(drawable)
    }

    @BindingAdapter("bind:srcBitmap")
    @JvmStatic
    fun setBitmap(iv: ImageView, bitmap: Bitmap) {
        iv.setImageBitmap(bitmap)
    }

    @BindingAdapter("bind:cardBackgroundStringColor")
    @JvmStatic
    fun setCardBackgroundColor(cardView: MaterialCardView, colorString:String) {
        cardView.setCardBackgroundColor(Color.parseColor(colorString))
    }
}