package com.toni.tiplog.feature_tip.presentation.tip

import android.widget.DatePicker

data class TipState (
    val tipAmount: String = "",
    val showDialog: Boolean = false,
    val isLoading: Boolean = false,
    val date: String = "",
    val error: String = "",
    val showToast: Boolean = false
)