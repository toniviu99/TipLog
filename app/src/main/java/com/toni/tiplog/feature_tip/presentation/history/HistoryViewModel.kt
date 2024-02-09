package com.toni.tiplog.feature_tip.presentation.history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getTipsUseCase: GetTipsUseCase
): ViewModel() {

    var state by mutableStateOf(HistoryState())
        private set

    private var getTips: Job? = null

    init {
        getTips()
    }

    private fun getTips() {
        state = state.copy(isLoading = true)
        println()
//        getTips?.cancel()
//        getTips = getTipsUseCase().onEach {
//            state = state.copy(
//                tips = it
//            )
//        }
//            .launchIn(viewModelScope)
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