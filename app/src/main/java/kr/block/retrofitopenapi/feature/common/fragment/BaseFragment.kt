package kr.block.retrofitopenapi.feature.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<BINDING : ViewDataBinding>(@LayoutRes val layout: Int) : Fragment() {

    protected lateinit var mBinder: BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinder = DataBindingUtil.inflate(inflater, layout, container, false)
        return mBinder.root
    }
}