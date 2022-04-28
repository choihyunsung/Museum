package kr.block.retrofitopenapi.feature.main.networktech.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentNetworkTechnologyBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment
import kr.block.retrofitopenapi.feature.main.networktech.adapter.NetworkTechnologyAdapter
import kr.block.retrofitopenapi.feature.main.networktech.adapter.item.NetworkTechnologyData
import java.util.*

class NetworkTechnologyFragment :
    BaseFragment<FragmentNetworkTechnologyBinding>(R.layout.fragment_network_technology) {

    companion object {
        fun newInstance(): NetworkTechnologyFragment = NetworkTechnologyFragment()
    }

    enum class RestApiType(
        @StringRes
        val stringRes: Int)
    {
        KOFIC(R.string.kofic_text), //영화진흥위원회
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(mBinder) {
            rvList.adapter = NetworkTechnologyAdapter(createList())
        }
    }

    //TODO HSCHOE 나중에 Mata데이터등으로 만들어야함.
    private fun createList(): List<NetworkTechnologyData> {
        var list:MutableList<NetworkTechnologyData> = mutableListOf()
        list.add(NetworkTechnologyData(R.drawable.card_10_item_2, "영화진흥위원회 API",RestApiType.KOFIC))
        return list
    }
}