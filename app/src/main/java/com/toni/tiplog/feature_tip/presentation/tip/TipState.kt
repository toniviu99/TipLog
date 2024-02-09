package com.toni.tiplog.feature_tip.presentation.tip

import android.widget.DatePicker

data class TipState (
    val tipAmount: String = "0.0",
    val showDialog: Boolean = false,
    val isLoading: Boolean = false,
    val date: String = "",
    val error: String = "",
)