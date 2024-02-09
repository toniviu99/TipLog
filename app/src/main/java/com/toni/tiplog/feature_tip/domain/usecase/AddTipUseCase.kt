package com.toni.tiplog.feature_tip.domain.usecase

import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.repository.TipRepository

class AddTipUseCase(private val repository: TipRepository) {
    suspend operator fun invoke(tip: Tip){
        repository.insertTip(tip)
    }
}