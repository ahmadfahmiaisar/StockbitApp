package com.example.stockbitapp.domain.repository

import com.example.base.state.Either
import com.example.stockbitapp.domain.entity.TotalTopTierVolume

interface CustomerRepository {

    suspend fun getTotalTopTierVolume(page: Int, limit: Int): Either<Exception, List<TotalTopTierVolume>>
}