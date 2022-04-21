package kr.block.retrofitopenapi.feature.common.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDialog<BINDING : ViewDataBinding>(
    var context: Activity,
    @LayoutRes var layout: Int
) {
    protected val dialog: Dialog = Dialog(context)
    protected val mBinder: BINDING
    var isCancelable: Boolean = false
        set(value) {
            field = value
            dialog.setCancelable(value)
        }

    init {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) //Title Remove
        mBinder = DataBindingUtil.inflate(LayoutInflater.from(context), layout, null, false)
        dialog.setContentView(mBinder.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}