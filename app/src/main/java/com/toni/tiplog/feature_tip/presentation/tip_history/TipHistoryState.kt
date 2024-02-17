package com.toni.tiplog.feature_tip.presentation.tip_history

import com.toni.tiplog.feature_tip.domain.model.Tip

data class TipHistoryState (
    val tips: List<Tip> = emptyList(),
    val isLoading: Boolean = false,
)