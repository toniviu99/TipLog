package com.toni.tiplog.feature_tip.presentation.history

import com.toni.tiplog.feature_tip.domain.model.Tip

data class HistoryState(
    val tips: List<Tip> = emptyList(),
    val isLoading: Boolean = false
)
