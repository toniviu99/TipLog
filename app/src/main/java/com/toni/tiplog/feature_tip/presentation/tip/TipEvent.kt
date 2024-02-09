package com.toni.tiplog.feature_tip.presentation.tip

sealed interface TipEvent{
    data class TipChange(val tipAmount: String) : TipEvent
    data class ShowDialogChange(val showDialog: Boolean): TipEvent
    data class DateChange(val date: String): TipEvent
    object SaveTip: TipEvent
}