package kr.block.retrofitopenapi.feature.main.menu.activity

import android.os.Bundle
import android.view.View
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityDefaultSetBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity

class DefaultSetActivity : BaseActivity<ActivityDefaultSetBinding>(R.layout.activity_default_set) {

    init {
        backKeyGuard = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            title.leftBtn.setOnClickListener(this@DefaultSetActivity::onBack)
        }
    }

    private fun onBack(view: View?) {
        finish()
    }
}