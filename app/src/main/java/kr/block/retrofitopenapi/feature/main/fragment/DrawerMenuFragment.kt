package kr.block.retrofitopenapi.feature.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentMainDrawerMenuBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment

class DrawerMenuFragment : BaseFragment<FragmentMainDrawerMenuBinding>(R.layout.fragment_main_drawer_menu) {

    companion object {
        fun newInstance():Fragment = DrawerMenuFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}