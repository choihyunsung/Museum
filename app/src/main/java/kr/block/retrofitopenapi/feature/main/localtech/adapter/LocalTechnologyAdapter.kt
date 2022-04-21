package kr.block.retrofitopenapi.feature.main.localtech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.block.retrofitopenapi.databinding.ItemLocalTechnologyBinding
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
        holder.bind(list[position])
        //TODO HSCHOE 여기선 Click리스너등을 달아주는 작업을 진행해야함.!
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