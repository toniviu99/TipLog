package com.toni.tiplog.feature_tip.domain.repository

import com.toni.tiplog.feature_tip.domain.model.MonthAmount
import com.toni.tiplog.feature_tip.domain.model.Tip
import kotlinx.coroutines.flow.Flow

interface TipRepository {
    fun getTips(): Flow<List<Tip>>

    fun getMonths(): Flow<List<MonthAmount>>

    fun getTipsByMonth(month: String):Flow<List<Tip>>

    suspend fun insertTip(tip:Tip)

    suspend fun deleteTip(tip: Tip)
}