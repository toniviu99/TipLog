package com.toni.tiplog.feature_tip.data.repository

import com.toni.tiplog.feature_tip.data.local.TipDao
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import kotlinx.coroutines.flow.Flow

class TipRepositoryImpl(private val dao: TipDao): TipRepository {
    override fun getTips(): Flow<List<Tip>> {
        return dao.getAllTips()
    }

    override suspend fun insertTip(tip: Tip) {
        return dao.insertTip(tip)
    }

    override suspend fun deleteTip(tip: Tip) {
        return dao.deleteTip(tip)
    }
}