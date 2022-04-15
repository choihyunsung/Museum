package kr.block.retrofitopenapi.feature.intro

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityTutorialBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.intro.adapter.TutorialAdapter
import kr.block.retrofitopenapi.feature.intro.adapter.item.TutorialData
import kr.block.retrofitopenapi.feature.main.MainActivity
import timber.log.Timber
import java.util.*

class TutorialActivity : BaseActivity<ActivityTutorialBinding>(R.layout.activity_tutorial) {
    lateinit var viewModel: TutorialViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            activity = this@TutorialActivity
            viewModel = ViewModelProvider(this@TutorialActivity)[TutorialViewModel::class.java]
            tutorialPager.adapter = TutorialAdapter(getTutorialData())
            tutorialPager.registerOnPageChangeCallback(onPagerCallback)
            indicator.setViewPager(tutorialPager)
            indicator.moveToClickDotPos = true
            viewModel.pagerIndex.observe(this@TutorialActivity) {
                isStart = (it <= 0)
                isEnd = (it >= indicator.pager!!.adapter!!.itemCount - 1)
            }

        }
    }

    fun onNextPage() {
        mBinder.tutorialPager.run {
            if (currentItem < adapter?.itemCount!!) currentItem += 1
        }
    }

    fun onPrevPage() {
        mBinder.tutorialPager.run {
            if (currentItem > 0) currentItem -= 1
        }
    }

    fun onSkipPage() {
        mBinder.tutorialPager.run {
            currentItem = adapter?.itemCount!!
        }
    }

    fun moveToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_DPAD_RIGHT -> onNextPage()
            KeyEvent.KEYCODE_DPAD_LEFT -> onPrevPage()
        }
        return super.onKeyUp(keyCode, event)
    }

    private val onPagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            viewModel.pagerIndex.value = position
        }
    }

    private fun getTutorialData(): List<TutorialData> {
        return listOf(
            TutorialData(
                "첫번째",
                "환영합니다",
                R.drawable.witch_0
            ),
            TutorialData(
                "두번째",
                "신비한 모험이 기다려요",
                R.drawable.cell
            ),
            TutorialData(
                "세번째",
                "단한번의 클릭으로 손쉬운 아이템 검색",
                R.drawable.collectbag
            ),
            TutorialData(
                "네번째",
                "지금 바로 시작해보세요.",
                R.drawable.alchemy
            )
        )
    }

    class TutorialViewModel : ViewModel() {
        var pagerIndex: MutableLiveData<Int> = MutableLiveData(0)
    }
}