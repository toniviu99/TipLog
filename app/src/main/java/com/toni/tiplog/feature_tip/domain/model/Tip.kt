package com.toni.tiplog.feature_tip.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Tip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Float,
    val date: Long
)