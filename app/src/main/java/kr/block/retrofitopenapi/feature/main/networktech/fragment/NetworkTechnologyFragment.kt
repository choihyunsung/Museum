package kr.block.retrofitopenapi.feature.main.networktech.fragment

import android.os.Bundle
import android.view.View
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentNetworkTechnologyBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment

class NetworkTechnologyFragment :
    BaseFragment<FragmentNetworkTechnologyBinding>(R.layout.fragment_network_technology) {

    companion object {
        fun newInstance():NetworkTechnologyFragment = NetworkTechnologyFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}