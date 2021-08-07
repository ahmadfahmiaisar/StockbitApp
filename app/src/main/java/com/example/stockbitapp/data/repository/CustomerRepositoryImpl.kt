package com.example.stockbitapp.data.repository

import com.example.base.state.Either
import com.example.stockbitapp.data.mapper.TotalTopTierVolumeMapper
import com.example.stockbitapp.data.source.CustomerRemoteDataSource
import com.example.stockbitapp.domain.entity.TotalTopTierVolume
import com.example.stockbitapp.domain.repository.CustomerRepository
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val remoteDataSource: CustomerRemoteDataSource,
    private val totalTopTierVolumeMapper: TotalTopTierVolumeMapper
) : CustomerRepository {
    override suspend fun getTotalTopTierVolume(): Either<Exception, List<TotalTopTierVolume>> {
        val apiResult = remoteDataSource.getTotalTopTierVolume()
        return when (apiResult) {
            is Either.Failure -> Either.Failure(apiResult.cause)
            is Either.Success -> Either.Success(totalTopTierVolumeMapper.map(apiResult.data))
        }
    }
}