package com.toni.tiplog.feature_tip.presentation.month_history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.tiplog.feature_tip.domain.usecase.GetMonthsUseCase
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MonthHistoryViewModel @Inject constructor(
    private val getTipsUseCase: GetTipsUseCase,
    private val getMonthsUseCase: GetMonthsUseCase
): ViewModel() {

    var state by mutableStateOf(MonthHistoryState())
        private set

    init {
//        getTips()
        getMonths()
    }

    private fun getMonths() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            getMonthsUseCase().collectLatest {
                state = state.copy(
                    months = it
                )
            }
        }
        state = state.copy(isLoading = false)
    }

    private fun getTips() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            getTipsUseCase().collectLatest {
                state = state.copy(
                    tips = it
                )
            }
        }
        state = state.copy(isLoading = false)

    }
}