package kr.block.retrofitopenapi.feature.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityIntroBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding>(R.layout.activity_intro) {
    companion object {
        const val DELAYED = 2000L
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this,TutorialActivity::class.java))
            finish()
        }, DELAYED)
    }
}