package com.toni.tiplog.feature_tip.data.mapper

import com.toni.tiplog.feature_tip.data.local.entity.TipEntity
import com.toni.tiplog.feature_tip.domain.model.Tip
import java.time.LocalDate

fun TipEntity.toDomain(): Tip {
    return Tip(
        id = id,
        amount = amount,
        date = LocalDate.parse(date)
    )
}