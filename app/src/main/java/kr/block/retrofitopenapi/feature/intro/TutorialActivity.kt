package kr.block.retrofitopenapi.feature.intro

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityTutorialBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.intro.adapter.TutorialAdapter
import kr.block.retrofitopenapi.feature.intro.adapter.item.TutorialData
import kr.block.retrofitopenapi.feature.main.MainActivity

class TutorialActivity : BaseActivity<ActivityTutorialBinding>(R.layout.activity_tutorial) {
    lateinit var viewModel: TutorialViewModel

    init {
        backKeyGuard = true
    }

    enum class PageMovement {
        NEXT, // 다음
        PREV, // 이전
        SKIP // 건너뛰기
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            activity = this@TutorialActivity
            viewModel = ViewModelProvider(this@TutorialActivity)[TutorialViewModel::class.java]
            tutorialPager.run {
                (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                adapter = TutorialAdapter(getTutorialData())
                registerOnPageChangeCallback(onPagerCallback)
            }
            indicator.run {
                setViewPager(tutorialPager)
                moveToClickDotPos = true
            }
            viewModel.run {
                pagerIndex.observe(this@TutorialActivity) {
                    isStart = (it <= 0)
                    isEnd = (it >= indicator.pager!!.adapter!!.itemCount - 1)
                    pageCount = it+1
                }
            }
        }
    }

    fun onPageMove(pageMove: PageMovement) {
        mBinder.tutorialPager.run {
            when (pageMove) {
                PageMovement.NEXT -> {
                    if (currentItem < adapter?.itemCount!!) currentItem += 1
                }
                PageMovement.PREV -> {
                    if (currentItem > 0) currentItem -= 1
                }
                PageMovement.SKIP -> {
                    currentItem = adapter?.itemCount!!
                }
            }
        }
    }

    fun moveToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
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