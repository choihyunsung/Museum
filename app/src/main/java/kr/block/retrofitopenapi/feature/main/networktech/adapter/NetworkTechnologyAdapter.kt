package kr.block.retrofitopenapi.feature.main.networktech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ktx.BuildConfig
import androidx.recyclerview.widget.RecyclerView
import kr.block.retrofitopenapi.databinding.ItemNetworkTechnologyBinding
import kr.block.retrofitopenapi.feature.main.networktech.activity.NetworkApiViewerActivity
import kr.block.retrofitopenapi.feature.main.networktech.adapter.item.NetworkTechnologyData
import kr.block.retrofitopenapi.feature.main.networktech.fragment.NetworkTechnologyFragment
import kr.block.retrofitopenapi.feature.main.networktech.fragment.NetworkTechnologyFragment.*

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
        with(holder) {
            bind(list[position])
            mBinder.rootView.setOnClickListener {
                NetworkApiViewerActivity.createActivity(
                    holder.mBinder.root.context,
                    mBinder.data!!.apiType
                )

            }
        }

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