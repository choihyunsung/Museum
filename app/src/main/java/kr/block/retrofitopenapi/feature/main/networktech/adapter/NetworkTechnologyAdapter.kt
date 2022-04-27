package kr.block.retrofitopenapi.feature.main.networktech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ktx.BuildConfig
import androidx.recyclerview.widget.RecyclerView
import kr.block.retrofitopenapi.databinding.ItemNetworkTechnologyBinding
import kr.block.retrofitopenapi.feature.main.networktech.adapter.item.NetworkTechnologyData

class NetworkTechnologyAdapter(var list: List<NetworkTechnologyData>) :
    RecyclerView.Adapter<NetworkTechnologyAdapter.NetworkTechnologyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkTechnologyHolder {
        return NetworkTechnologyHolder(
            ItemNetworkTechnologyBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NetworkTechnologyHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class NetworkTechnologyHolder(val mBinder: ItemNetworkTechnologyBinding) :
        RecyclerView.ViewHolder(mBinder.root) {

        fun bind(data: NetworkTechnologyData) {
            mBinder.data = data
            mBinder.executePendingBindings()
        }
    }
}