package com.toni.tiplog.feature_tip.presentation.tip_history

import com.toni.tiplog.feature_tip.domain.model.Tip

sealed interface TipHistoryEvent {
    data class DeleteTip(val tip: Tip):TipHistoryEvent
}