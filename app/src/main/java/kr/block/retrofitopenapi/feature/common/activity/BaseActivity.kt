package kr.block.retrofitopenapi.feature.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.block.retrofitopenapi.feature.common.dialog.LottieProgressDialog

abstract class BaseActivity<BINDER : ViewDataBinding>(@LayoutRes val layoutRes: Int) :
    AppCompatActivity() {
    protected lateinit var mBinder: BINDER
    protected var backKeyGuard: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinder = DataBindingUtil.setContentView(this, layoutRes)
    }

    fun showProgressDialog() {
        LottieProgressDialog.getInstance(this).show()
    }

    fun dismissProgressDialog() {
        LottieProgressDialog.getInstance(this).dismiss()
    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(0, 0)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onBackPressed() {
        if (!backKeyGuard) {
            super.onBackPressed()
        }
    }
}