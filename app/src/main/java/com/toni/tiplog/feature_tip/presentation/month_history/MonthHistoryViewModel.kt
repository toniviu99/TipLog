package com.toni.tiplog.feature_tip.presentation.month_history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.toni.tiplog.feature_tip.domain.usecase.GetMonthsUseCase
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.YearMonth
import java.util.Locale
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
                val formattedMonths = it.map {
                    it.copy(month = formatDate(it.month))
                }
                state = state.copy(
                    months = formattedMonths
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

    private fun formatDate(inputDate:String):String{
        val inputFormat = SimpleDateFormat("yyyy-MM", Locale.getDefault())
        val outputFormat = SimpleDateFormat("MM/yyyy", Locale.getDefault())
        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date)
    }
}