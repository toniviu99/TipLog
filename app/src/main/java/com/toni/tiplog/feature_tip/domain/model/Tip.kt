package com.toni.tiplog.feature_tip.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


//data class Tip(
//    val amount: Double,
//    val date: String
//)

@Entity
data class Tip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Double,
    val date: String
)
