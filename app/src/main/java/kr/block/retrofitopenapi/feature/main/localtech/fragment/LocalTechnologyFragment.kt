package kr.block.retrofitopenapi.feature.main.localtech.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.PagerSnapHelper
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentLocalTechnologyBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment
import kr.block.retrofitopenapi.feature.main.localtech.adapter.LocalTechnologyAdapter
import kr.block.retrofitopenapi.feature.main.localtech.adapter.item.LocalTechnologyData

class LocalTechnologyFragment :
    BaseFragment<FragmentLocalTechnologyBinding>(R.layout.fragment_local_technology) {
    companion object {
        fun newInstance(): LocalTechnologyFragment = LocalTechnologyFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(mBinder) {
            rvLocalTech.adapter = LocalTechnologyAdapter(createTechData())
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(rvLocalTech)
        }
    }

    //FIXME HSCHOE 나중에 서버나 ROOM에서 받도록 처리해야함.
    private fun createTechData(): List<LocalTechnologyData> {
        var list = mutableListOf<LocalTechnologyData>()
        for (x in 0..5) {
            val data = when {
                x % 2 == 0 -> {
                    LocalTechnologyData("Blooth", R.drawable.tree1, "#FFFFFFFF", "블루투스 어쩌구 저쩌구")
                }
                x%3 ==0 -> {
                    LocalTechnologyData("CustomView", R.drawable.cell, "#FFBA68C8", "커스텀뷰 어쩌구 저쩌ㅜ ")
                }
                else -> {
                    LocalTechnologyData("ROOM DB", R.drawable.alchemy, "#FFFFFFFF", "룸디비 어쩌구저쩌구 ")
                }
            }
            list.add(data)
        }
        return list
    }
}