package com.toni.tiplog.feature_tip.presentation.tip_history

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.tiplog.feature_tip.domain.usecase.DeleteTipUseCase
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsByMonthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TipHistoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getTipsByMonthUseCase: GetTipsByMonthUseCase,
    private val deleteTipUseCase: DeleteTipUseCase
) : ViewModel() {
    var state by mutableStateOf(TipHistoryState())
        private set

    private val month = savedStateHandle.get<String>("month")

    init {
        getTipsByMonth()
    }

    fun onEvent(event: TipHistoryEvent) {
        when (event) {
            is TipHistoryEvent.DeleteTip -> {
                viewModelScope.launch {
                    deleteTipUseCase(event.tip)
                }
            }
        }
    }

    private fun getTipsByMonth() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            if (month != null) {
                getTipsByMonthUseCase(month).collectLatest {
                    state = state.copy(
                        tips = it
                    )
                }
            }

        }
        state = state.copy(isLoading = false)
    }
}