package com.example.stockbitapp.data.service

import com.example.stockbitapp.data.response.TotalTopTierVolumeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomerService {

    @GET("data/top/totaltoptiervolfull")
    suspend fun getTotalTopTierVolume(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("tsym") tsym: String = "USD"
    ): Response<TotalTopTierVolumeDto>
}