package com.example.stockbitapp.domain.entity

data class TotalTopTierVolume(
    val coinInfo: CoinInfo,
    val display: DISPLAY
) {
    data class CoinInfo(
        val id: String,
        val fullName: String,
        val name: String
    )

    data class DISPLAY(
        val usd: USD
    ) {
        data class USD(
            val price: String,
        )
    }
}