package com.toni.tiplog.feature_tip.presentation.calendar

import com.toni.tiplog.feature_tip.domain.model.Tip

data class CalendarState(
    val tips: List<Tip> = emptyList(),
    val isLoading: Boolean = false,
    val currentMonth: String? = null
)