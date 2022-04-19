package kr.block.retrofitopenapi.feature.main.menu.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentMainDrawerMenuBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment

class DrawerMenuFragment :
    BaseFragment<FragmentMainDrawerMenuBinding>(R.layout.fragment_main_drawer_menu),
    View.OnClickListener {

    companion object {
        fun newInstance(): Fragment = DrawerMenuFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(mBinder) {
            menuProfile.rootView.setOnClickListener(this@DrawerMenuFragment)
            menuDefaultSet.rootView.setOnClickListener(this@DrawerMenuFragment)
        }
    }

    override fun onClick(view: View?) {
        with(mBinder) {
            when (view) {
                menuProfile.rootView -> {
                    Toast.makeText(context, "프로필", Toast.LENGTH_LONG).show()
                }
                menuDefaultSet.rootView -> {
                    Toast.makeText(context, "기본세팅", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}