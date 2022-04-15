package kr.block.retrofitopenapi.feature.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<BINDER : ViewDataBinding>(@LayoutRes val layoutRes: Int) : AppCompatActivity() {
    protected lateinit var mBinder: BINDER
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinder = DataBindingUtil.setContentView(this, layoutRes)
    }
}