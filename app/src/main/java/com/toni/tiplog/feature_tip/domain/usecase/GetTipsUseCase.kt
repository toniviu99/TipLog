package com.toni.tiplog.feature_tip.domain.usecase

import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import kotlinx.coroutines.flow.Flow

class GetTipsUseCase (private val repository: TipRepository){
    operator fun invoke(): Flow<List<Tip>> {
        return repository.getTips()
    }
}