package kr.block.retrofitopenapi.feature.main

import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityMainBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.main.fragment.DrawerMenuFragment
import kr.block.retrofitopenapi.utils.DisplayUtils
import timber.log.Timber

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            initDrawerLayout(DrawerMenuFragment.newInstance())
            mainTitle.ivMenuBtn.setOnClickListener {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) drawerLayout.closeDrawer(
                    GravityCompat.END
                ) else drawerLayout.openDrawer(GravityCompat.END)
            }
        }
    }

    private fun initDrawerLayout(menuFragment: Fragment) {
        val loc: Pair<Int, Int> = DisplayUtils.displaySize(this@MainActivity)
        //Size Full
        with(mBinder.containerDrawer) {
            val param = this.layoutParams
            param.width = loc.first
            this.layoutParams = param
        }
        supportFragmentManager
            .beginTransaction()
            .replace(mBinder.containerDrawer.id, menuFragment)
            .commit()
    }
}