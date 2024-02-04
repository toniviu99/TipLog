package com.toni.tiplog.feature_tip.presentation.tip

sealed interface TipEvent{
    data class TipChange(val tipAmount: String) : TipEvent
}