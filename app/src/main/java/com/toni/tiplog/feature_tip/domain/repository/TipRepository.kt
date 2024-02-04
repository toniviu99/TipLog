package com.toni.tiplog.feature_tip.domain.repository

import com.toni.tiplog.feature_tip.domain.model.Tip
import kotlinx.coroutines.flow.Flow

interface TipRepository {
    fun getTips(): Flow<List<Tip>>

    suspend fun insertTip(tip:Tip)

    suspend fun deleteTip(tip: Tip)
}