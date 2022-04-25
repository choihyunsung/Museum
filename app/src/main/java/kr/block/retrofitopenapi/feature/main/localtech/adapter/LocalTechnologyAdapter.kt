package kr.block.retrofitopenapi.feature.main.localtech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.block.retrofitopenapi.databinding.ItemLocalTechnologyBinding
import kr.block.retrofitopenapi.feature.main.localtech.activity.LocalTechListActivity
import kr.block.retrofitopenapi.feature.main.localtech.adapter.item.LocalTechnologyData

class LocalTechnologyAdapter(var list: List<LocalTechnologyData>) :
    RecyclerView.Adapter<LocalTechnologyAdapter.LocalTechnologyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalTechnologyHolder {
        return LocalTechnologyHolder(
            ItemLocalTechnologyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LocalTechnologyHolder, position: Int) {
        with(holder) {
            bind(list[position])
            mBinder.rootInCard.setOnClickListener {
                LocalTechListActivity.createActivity(mBinder.root.context, mBinder.data!!.Techtype)
            }
        }

    }

    override fun getItemCount() = list.size

    class LocalTechnologyHolder(var mBinder: ItemLocalTechnologyBinding) :
        RecyclerView.ViewHolder(mBinder.root) {
        fun bind(data: LocalTechnologyData) {
            mBinder.data = data
            mBinder.executePendingBindings()
        }
    }
}