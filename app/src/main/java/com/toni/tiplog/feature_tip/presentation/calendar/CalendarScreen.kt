package com.toni.tiplog.feature_tip.presentation.calendar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.toni.tiplog.feature_tip.presentation.calendar.components.Day
import com.toni.tiplog.feature_tip.presentation.calendar.components.DaysOfWeekTitle
import java.time.YearMonth


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = hiltViewModel()
) {
    var state = viewModel.state

    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            val currentMonth = remember { YearMonth.now() }
            val startMonth = remember { currentMonth.minusMonths(100) }
            val endMonth = remember { currentMonth.plusMonths(100) }
            val firstDayOfWeek = remember { firstDayOfWeekFromLocale() }
            val calendarState = rememberCalendarState(
                startMonth = startMonth,
                endMonth = endMonth,
                firstVisibleMonth = currentMonth,
                firstDayOfWeek = firstDayOfWeek,
            )
            val daysOfWeek = daysOfWeek()
            viewModel.onEvent(CalendarEvent.CalendarMonthChange(currentMonth.toString()))
            HorizontalCalendar(
                state = calendarState,
                dayContent = { Day(it, true) },
                monthHeader = {
                    DaysOfWeekTitle(daysOfWeek = daysOfWeek)
                },
                )

        }
    }


}