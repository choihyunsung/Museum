package kr.block.retrofitopenapi.feature.main.menu.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.FragmentMainDrawerMenuBinding
import kr.block.retrofitopenapi.feature.common.fragment.BaseFragment
import kr.block.retrofitopenapi.feature.main.menu.activity.DefaultSetActivity
import kr.block.retrofitopenapi.feature.main.menu.activity.ProfileActivity

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
                    startActivity(
                        Intent(
                            this@DrawerMenuFragment.requireContext(),
                            ProfileActivity::class.java
                        )
                    )
                }
                menuDefaultSet.rootView -> {
                    startActivity(
                        Intent(
                            this@DrawerMenuFragment.requireContext(),
                            DefaultSetActivity::class.java
                        )
                    )
                }
            }
        }
    }
}