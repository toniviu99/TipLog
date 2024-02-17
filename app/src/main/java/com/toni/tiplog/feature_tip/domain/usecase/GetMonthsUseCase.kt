package com.toni.tiplog.feature_tip.domain.usecase

import com.toni.tiplog.feature_tip.domain.model.MonthAmount
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import kotlinx.coroutines.flow.Flow


class GetMonthsUseCase (private val repository: TipRepository){
    operator fun invoke(): Flow<List<MonthAmount>> {
        return repository.getMonths()
    }
}