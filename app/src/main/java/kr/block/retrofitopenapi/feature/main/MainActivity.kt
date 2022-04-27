package kr.block.retrofitopenapi.feature.main

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.ktx.BuildConfig
import androidx.fragment.app.Fragment
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityMainBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.main.localtech.fragment.LocalTechnologyFragment
import kr.block.retrofitopenapi.feature.main.menu.fragment.DrawerMenuFragment
import kr.block.retrofitopenapi.feature.main.networktech.fragment.NetworkTechnologyFragment
import kr.block.retrofitopenapi.utils.DisplayUtils

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            initDrawerLayout(DrawerMenuFragment.newInstance())
            mainTitle.ivMenuBtn.setOnClickListener(drawerMenuClickListener)
            drawerTitle.ivMenuBtn.setOnClickListener(drawerMenuClickListener)
        }
    }

    private val drawerMenuClickListener = View.OnClickListener {
        if (mBinder.drawerLayout.isDrawerOpen(GravityCompat.END)) mBinder.drawerLayout.closeDrawer(
            GravityCompat.END
        ) else mBinder.drawerLayout.openDrawer(GravityCompat.END)
    }

    private fun initDrawerLayout(menuFragment: Fragment) {
        val loc: Pair<Int, Int> = DisplayUtils.displaySize(this@MainActivity)
        //Size Full
        with(mBinder.rootDrawerMenu) {
            val param = this.layoutParams
            param.width = loc.first
            this.layoutParams = param
        }
        supportFragmentManager
            .beginTransaction()
            .replace(mBinder.containerDrawer.id, menuFragment)
            .commit()
    }

    override fun onBackPressed() {
        with(mBinder.drawerLayout) {
            if(isDrawerOpen(GravityCompat.END)) {
               closeDrawer(GravityCompat.END)
            } else {
                super.onBackPressed()
            }
        }

    }
}