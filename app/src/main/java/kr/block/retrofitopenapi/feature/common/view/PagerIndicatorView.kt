package kr.block.retrofitopenapi.feature.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.get
import androidx.core.view.setPadding
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.generated.callback.OnClickListener
import kr.block.retrofitopenapi.utils.DisplayUtils
import timber.log.Timber

class PagerIndicatorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs), View.OnClickListener {

    var pager: ViewPager2? = null
    var moveToClickDotPos: Boolean = false

    init {
        orientation = height
        gravity = Gravity.CENTER
    }

    fun setViewPager(pager: ViewPager2) {
        this.pager = pager
        if (childCount < 0) {
            removeAllViews()
        }

        with(pager) {
            val dotCount =
                (adapter?.itemCount!!.minus(1)) //view child count start 0/ list count start 1
            for (x in 0..dotCount) {
                val dot = ImageView(context)
                val param = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
                val dpMargin = DisplayUtils.pxToDp(20)
                param.setMargins(dpMargin, 0, dpMargin, 0)
                param.weight = 1F
                dot.setOnClickListener(this@PagerIndicatorView)
                dot.layoutParams = param
                dot.setImageResource(R.drawable.indicator_non)
                this@PagerIndicatorView.addView(dot)
            }
        }
        pager.registerOnPageChangeCallback(onPagerCallback)
    }

    private val onPagerCallback = object : ViewPager2.OnPageChangeCallback() {
        private var prevDot: ImageView? = null
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            val posDot = getChildAt(position) as ImageView
            posDot.run {
                setImageResource(R.drawable.indicator_sel)
                animate().scaleX(1.5F).start()
            }
            prevDot?.run {
                setImageResource(R.drawable.indicator_non)
                animate().scaleX(1.0F).start()
            }
            prevDot = posDot
        }
    }

    override fun onClick(v: View) {
        if (moveToClickDotPos) {
            pager?.run {
                for (x in 0..this@PagerIndicatorView.childCount) {
                    if (v == this@PagerIndicatorView.getChildAt(x)) {
                        currentItem = x
                        break
                    }
                }
            }
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        pager?.unregisterOnPageChangeCallback(onPagerCallback)
    }


}