package com.example.stockbitapp.presentation.tiervolume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.abstraction.BaseFragment
import com.example.base.extension.gone
import com.example.base.extension.visible
import com.example.base.state.ViewState
import com.example.base.util.EndlessRecyclerOnScrollListener
import com.example.base.util.RecyclerviewDividerItemDecoration
import com.example.stockbitapp.databinding.FragmentTotalTopTierVolumeBinding
import com.example.stockbitapp.domain.entity.TotalTopTierVolumeUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TotalTopTierVolumeFragment :
    BaseFragment<FragmentTotalTopTierVolumeBinding, TotalTopTierVolumeViewModel>() {
    override val getViewBinding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTotalTopTierVolumeBinding
        get() = FragmentTotalTopTierVolumeBinding::inflate
    override val getViewModelClass: Class<TotalTopTierVolumeViewModel>
        get() = TotalTopTierVolumeViewModel::class.java

    private val adapter by lazy { TotalTopTierVolumeAdapter(emptyList()) }
    private var page = 1
    private var limit = 20
    private var totalTiers = mutableListOf<TotalTopTierVolumeUiModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeTotalTopTierVolume()
        vm.getTotalTopTierVolume(page, limit)
        initRecycleView()
    }

    private fun observeTotalTopTierVolume() {
        vm.totalTopTier.observe(viewLifecycleOwner, {
            when (it) {
                is ViewState.Loading -> {
                    binding.progressBar.visible()
                }
                is ViewState.Success -> {
                    binding.progressBar.gone()
                    totalTiers.addAll(it.data)
                    adapter.refreshData(totalTiers)
                }
                is ViewState.Error -> {
                    binding.progressBar.gone()
                }
            }
        })
    }

    private fun initRecycleView() {
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.recycleView.layoutManager = layoutManager
        binding.recycleView.addItemDecoration(RecyclerviewDividerItemDecoration(requireActivity()))
        binding.recycleView.adapter = adapter

        binding.recycleView.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener(layoutManager) {
            override fun onLoadMore(current_page: Int) {
                vm.getTotalTopTierVolume(current_page, limit)
            }

        })
    }
}
