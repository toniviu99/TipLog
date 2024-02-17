package com.toni.tiplog.feature_tip.presentation.month_history

import com.toni.tiplog.feature_tip.domain.model.MonthAmount
import com.toni.tiplog.feature_tip.domain.model.Tip

data class MonthHistoryState(
    val tips: List<Tip> = emptyList(),
    val months: List<MonthAmount> = emptyList(),
    val isLoading: Boolean = false
)
