package com.toni.tiplog.feature_tip.data.repository

import com.toni.tiplog.feature_tip.data.local.TipDao
import com.toni.tiplog.feature_tip.data.local.entity.TipEntity
import com.toni.tiplog.feature_tip.data.mapper.toDomain
import com.toni.tiplog.feature_tip.domain.model.MonthAmount
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

class TipRepositoryImpl(private val dao: TipDao) : TipRepository {
    override fun getTips(): Flow<List<Tip>> {
        return dao.getAllTips().map { tipEntityList ->
            tipEntityList.map { it.toDomain() }
        }
    }

    override fun getMonths(): Flow<List<MonthAmount>> {
        return dao.getMonthAmount()
    }

    override fun getTipsByMonth(month: String): Flow<List<Tip>> {
        return dao.getTipsByMonth(month).map { tipEntityList ->
            tipEntityList.map { it.toDomain() }
        }
    }

    override suspend fun insertTip(tip: Tip) {
        val entity = TipEntity(id = tip.id, amount = tip.amount, date = tip.date)
        return dao.insertTip(entity)
    }

    override suspend fun deleteTip(tip: Tip) {
        val entity = TipEntity(id = tip.id, amount = tip.amount, date = tip.date)
        return dao.deleteTip(entity)
    }
}