package kr.block.retrofitopenapi.feature.main.menu.activity

import android.os.Bundle
import android.view.View
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityProfileBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    init {
        backKeyGuard = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            title.leftBtn.setOnClickListener(this@ProfileActivity::onBack)
        }
    }

    private fun onBack(view: View?) {
        finish()
    }
}