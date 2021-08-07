package com.example.stockbitapp.data.response

import com.squareup.moshi.Json


data class TotalTopTierVolumeDto(
    @field:Json(name = "Data")
    val data: List<Data>? = null
) {
    data class Data(
        @field:Json(name = "CoinInfo")
        val coinInfo: CoinInfo? = null,
        @field:Json(name = "DISPLAY")
        val display: DISPLAY? = null
    ) {
        data class CoinInfo(
            @field:Json(name = "Id")
            val id: String? = null,
            @field:Json(name = "FullName")
            val fullName: String? = null,
            @field:Json(name = "Name")
            val name: String? = null
        )

        data class DISPLAY(
            @field:Json(name = "USD")
            val usd: USD? = null
        ) {

            data class USD(
                @field:Json(name = "PRICE")
                val price: String? = null,
            )
        }
    }
}
