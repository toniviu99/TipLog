package com.toni.tiplog.feature_tip.domain.usecase

import com.toni.tiplog.feature_tip.domain.model.MonthAmount
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class GetMonthsUseCase (private val repository: TipRepository){
    operator fun invoke(): Flow<List<MonthAmount>> {
        return repository.getMonths()
//        return repository.getMonths().map{
//            it.map {
//                val date = LocalDate.parse("${it.month}-01",DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//                val dateTransformed = date.format(DateTimeFormatter.ofPattern("MM/yyyy"))
//                it.copy(dateTransformed.toString(), it.totalAmount)
//            }
//        }
    }
}