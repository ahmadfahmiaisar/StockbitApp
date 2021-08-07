package com.example.stockbitapp.data.source

import com.example.base.apiclient.ApiClient
import com.example.base.state.ApiResponse
import com.example.base.state.Either
import com.example.stockbitapp.data.response.TotalTopTierVolumeDto
import com.example.stockbitapp.data.service.CustomerService
import javax.inject.Inject

class CustomerRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient,
    private val customerService: CustomerService
) {

    suspend fun getTotalTopTierVolume(): Either<Exception, TotalTopTierVolumeDto> {
        val response = apiClient.safeApiCall { customerService.getTotalTopTierVolume() }
        return when (response) {
            is ApiResponse.Success -> Either.Success(response.data)
            is ApiResponse.Failure -> Either.Failure(response.cause)
        }
    }
}