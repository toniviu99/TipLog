package com.toni.tiplog.feature_tip.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.toni.tiplog.feature_tip.domain.model.Tip

@Entity
data class TipEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val amount: Double,
    val date: String
)
