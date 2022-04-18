package kr.block.retrofitopenapi.feature.intro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.block.retrofitopenapi.databinding.ItemTutorialBinding
import kr.block.retrofitopenapi.feature.intro.adapter.item.TutorialData

class TutorialAdapter(var list: List<TutorialData>) :
    RecyclerView.Adapter<TutorialAdapter.TutorialHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialHolder {
        return TutorialHolder(
            ItemTutorialBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TutorialHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TutorialHolder(var binder: ItemTutorialBinding) :
        RecyclerView.ViewHolder(binder.root) {
        fun bind(data: TutorialData) {
            binder.data = data
            binder.executePendingBindings()
        }
    }
}