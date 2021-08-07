package com.example.stockbitapp.presentation.tiervolume

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockbitapp.databinding.ItemTopTierBinding
import com.example.stockbitapp.domain.entity.TotalTopTierVolumeUiModel

class TotalTopTierVolumeAdapter(var topTier: List<TotalTopTierVolumeUiModel>) :
    RecyclerView.Adapter<TotalTopTierVolumeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTopTierBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(topTier[position])
    }

    override fun getItemCount(): Int = topTier.size

    class ViewHolder(private val binding: ItemTopTierBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: TotalTopTierVolumeUiModel) {
            binding.tvName.text = model.name
            binding.tvFullName.text = model.fullName
            binding.tvPrice.text = model.price
        }
    }

    fun refreshData(topTier: List<TotalTopTierVolumeUiModel>) {
        this.topTier = topTier
        this.notifyDataSetChanged()
    }
}