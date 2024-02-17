package com.toni.tiplog.feature_tip.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Tip(
    val id: String,
    val amount: Double,
    val date: String
)
