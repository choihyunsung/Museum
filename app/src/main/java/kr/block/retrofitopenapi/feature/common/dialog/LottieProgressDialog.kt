package kr.block.retrofitopenapi.feature.common.dialog

import android.annotation.SuppressLint
import android.app.Activity
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.DialogLottieProgressBinding

/***
 * HSCHOE ProgressDialog는 딱히 넘겨줘야할 값이 없어서 Builder로 구현 안함.
 * 추후 Param 추가시에 Builder로 Refactoring 해야함.
 */
class LottieProgressDialog(context: Activity) :
    BaseDialog<DialogLottieProgressBinding>(context, R.layout.dialog_lottie_progress) {

    init {
        isCancelable = false
    }

    fun show() {
        context.runOnUiThread {
            if (!dialog.isShowing) {
                dialog.show()
            }
        }
    }

    fun dismiss() {
        context.runOnUiThread {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
    }
}