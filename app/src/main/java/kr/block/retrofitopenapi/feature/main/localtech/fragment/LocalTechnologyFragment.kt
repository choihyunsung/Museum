package kr.block.retrofitopenapi.feature.main.localtech.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.PagerSnapHelper
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentLocalTechnologyBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment
import kr.block.retrofitopenapi.feature.main.localtech.adapter.LocalTechnologyAdapter
import kr.block.retrofitopenapi.feature.main.localtech.adapter.item.LocalTechnologyData

class LocalTechnologyFragment :
    BaseFragment<FragmentLocalTechnologyBinding>(R.layout.fragment_local_technology) {

    enum class LocalTechType(
        @StringRes
        stringRes: Int)
    {
        CustomView(R.string.custom_view_text), //커스텀뷰
        Bluetooth(R.string.bluetooth_text), //블루투스
        DataBase(R.string.database_text) //데이터 베이스
    }

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
        return listOf(
            LocalTechnologyData(
                LocalTechType.CustomView,
                R.drawable.ic_view_in_ar_white_24dp,
                "#FF708090",
                "커스텀 뷰에 관련된 내용을 기입."
            ),
            LocalTechnologyData(
                LocalTechType.DataBase,
                R.drawable.ic_save_white_24dp,
                "#FF708090",
                "데이터 베이스에 관련된 내용을 기입."
            ),
            LocalTechnologyData(
                LocalTechType.Bluetooth,
                R.drawable.ic_cell_tower_white_24dp,
                "#FF708090",
                "블루투스에 관련된 내용을 기입."
            )
        )
    }
}