package com.example.stockbitapp.data.mapper

import com.example.base.abstraction.Mapper
import com.example.stockbitapp.data.response.TotalTopTierVolumeDto
import com.example.stockbitapp.domain.entity.TotalTopTierVolume
import javax.inject.Inject

class TotalTopTierVolumeMapper @Inject constructor() :
    Mapper<TotalTopTierVolumeDto, List<TotalTopTierVolume>> {
    override fun map(input: TotalTopTierVolumeDto): List<TotalTopTierVolume> {
        return input.data?.map {
            TotalTopTierVolume(
                coinInfo = TotalTopTierVolume.CoinInfo(
                    id = it.coinInfo?.id ?: "",
                    fullName = it.coinInfo?.fullName ?: "",
                    name = it.coinInfo?.name ?: ""
                ),
                display = TotalTopTierVolume.DISPLAY(
                    TotalTopTierVolume.DISPLAY.USD(
                        price = it.display?.usd?.price ?: ""
                    )
                )
            )
        } ?: emptyList()
    }
}