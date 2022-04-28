package kr.block.retrofitopenapi.feature.main.localtech.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityLocalTechologyListBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.main.localtech.fragment.LocalTechnologyFragment
import kr.block.retrofitopenapi.feature.main.localtech.fragment.LocalTechnologyFragment.*

class LocalTechListActivity :
    BaseActivity<ActivityLocalTechologyListBinding>(R.layout.activity_local_techology_list) {

    companion object {
        const val TECH_TYPE_KEY =
            "kr.block.retrofitopenapi.feature.main.localtech.activity.LocalTechListActivity.TECH_TYPE_KEY"

        fun createActivity(context: Context, techType: LocalTechType) {
            val intent = Intent(context, LocalTechListActivity::class.java).also {
                it.putExtra(TECH_TYPE_KEY, techType)
            }
            context.startActivity(intent)
        }
    }

    private val techType: LocalTechType by lazy {
        intent.getSerializableExtra(
            TECH_TYPE_KEY
        ) as LocalTechType
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            context = this@LocalTechListActivity
            techType = this@LocalTechListActivity.techType
        }
    }
}