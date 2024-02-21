package com.toni.tiplog.feature_tip.presentation.calendar

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsByMonthUseCase
import com.toni.tiplog.feature_tip.presentation.tip.TipEvent
import com.toni.tiplog.feature_tip.presentation.tip_history.TipHistoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.YearMonth
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getTipsByMonthUseCase: GetTipsByMonthUseCase,
):ViewModel() {
    var state by mutableStateOf(CalendarState())
        private set


    fun onEvent(event: CalendarEvent) {
        when(event){
            is CalendarEvent.CalendarMonthChange -> {
                state = state.copy(
                    currentMonth = event.calendarMonth
                )
                Log.d("toni", state.currentMonth.toString())
            }
        }
    }
}