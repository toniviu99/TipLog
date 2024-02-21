package com.toni.tiplog.feature_tip.presentation.calendar

import com.toni.tiplog.feature_tip.presentation.tip.TipEvent

sealed interface CalendarEvent {
    data class CalendarMonthChange(val calendarMonth: String) : CalendarEvent
}