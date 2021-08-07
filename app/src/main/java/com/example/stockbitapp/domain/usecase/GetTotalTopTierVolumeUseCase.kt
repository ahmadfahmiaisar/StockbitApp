package com.example.stockbitapp.domain.usecase

import com.example.base.abstraction.UseCase
import com.example.base.state.Either
import com.example.stockbitapp.domain.entity.TotalTopTierParams
import com.example.stockbitapp.domain.entity.TotalTopTierVolume
import com.example.stockbitapp.domain.entity.TotalTopTierVolumeUiModel
import com.example.stockbitapp.domain.repository.CustomerRepository
import javax.inject.Inject

class GetTotalTopTierVolumeUseCase @Inject constructor(private val repository: CustomerRepository) :
    UseCase<TotalTopTierParams, Either<Exception, List<TotalTopTierVolumeUiModel>>> {
    override suspend fun invoke(params: TotalTopTierParams): Either<Exception, List<TotalTopTierVolumeUiModel>> {
        return handleData(repository.getTotalTopTierVolume(params.page, params.limit))
    }

    private fun handleData(result: Either<Exception, List<TotalTopTierVolume>>): Either<Exception, List<TotalTopTierVolumeUiModel>> {
        return when (result) {
            is Either.Success -> Either.Success(formatData(result.data))
            is Either.Failure -> Either.Failure(result.cause)
        }
    }

    private fun formatData(data: List<TotalTopTierVolume>): List<TotalTopTierVolumeUiModel> {
        return data.map { it.toUiModel() }
    }

    private fun TotalTopTierVolume.toUiModel(): TotalTopTierVolumeUiModel {
        return TotalTopTierVolumeUiModel(
            id = this.coinInfo.id,
            fullName = this.coinInfo.fullName,
            name = this.coinInfo.name,
            price = this.display.usd.price
        )
    }
}