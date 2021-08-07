package com.example.stockbitapp.data.service

import com.example.stockbitapp.data.response.TotalTopTierVolumeDto
import retrofit2.Response
import retrofit2.http.GET

interface CustomerService {

    @GET("data/top/totaltoptiervolfull?limit=20&tsym=USD")
    suspend fun getTotalTopTierVolume(): Response<TotalTopTierVolumeDto>
}