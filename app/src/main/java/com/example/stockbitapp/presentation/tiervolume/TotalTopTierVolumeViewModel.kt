package com.example.stockbitapp.presentation.tiervolume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.dispatcher.DispatcherProvider
import com.example.base.extension.onError
import com.example.base.extension.onSuccess
import com.example.base.state.ViewState
import com.example.stockbitapp.domain.entity.TotalTopTierParams
import com.example.stockbitapp.domain.entity.TotalTopTierVolumeUiModel
import com.example.stockbitapp.domain.usecase.GetTotalTopTierVolumeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class TotalTopTierVolumeViewModel @Inject constructor(
    private val getTotalTopTierVolumeUseCase: GetTotalTopTierVolumeUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _totalTopTier = MutableLiveData<ViewState<List<TotalTopTierVolumeUiModel>>>()
    val totalTopTier: LiveData<ViewState<List<TotalTopTierVolumeUiModel>>>
        get() = _totalTopTier

    fun getTotalTopTierVolume(page: Int, limit: Int) {
        _totalTopTier.value = ViewState.Loading
        viewModelScope.launch(dispatcherProvider.io) {
            getTotalTopTierVolumeUseCase
                .invoke(TotalTopTierParams(page, limit))
                .onSuccess { topTier -> _totalTopTier.postValue(ViewState.Success(topTier)) }
                .onError { cause -> _totalTopTier.postValue(ViewState.Error(cause)) }
        }
    }
}