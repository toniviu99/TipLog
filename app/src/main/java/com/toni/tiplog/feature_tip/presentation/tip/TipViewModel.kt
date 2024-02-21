package com.toni.tiplog.feature_tip.presentation.tip

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.usecase.AddTipUseCase
import com.toni.tiplog.feature_tip.domain.usecase.AmountResult
import com.toni.tiplog.feature_tip.domain.usecase.ValidateAmountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TipViewModel @Inject constructor(
    private val addTipUseCase: AddTipUseCase,
    private val validateAmountUseCase: ValidateAmountUseCase,
) : ViewModel() {
    var state by mutableStateOf(TipState())
        private set

    init {
        getCurrentDate()
    }

    fun onEvent(event: TipEvent) {
        when (event) {
            is TipEvent.TipChange -> {
                state = state.copy(
                    tipAmount = event.tipAmount
                )
            }

            is TipEvent.ShowDialogChange -> {
                state = state.copy(
                    showDialog = event.showDialog
                )
            }

            is TipEvent.DateChange -> {
                state = state.copy(
                    date = event.date
                )
            }

            is TipEvent.ShowToast -> {
                state = state.copy(
                    showToast = event.showToast
                )
            }

            TipEvent.SaveTip -> saveTip()

        }
    }

    private fun saveTip() {
        val id = UUID.randomUUID().toString()
        val amountResult = validateAmountUseCase(state.tipAmount)
        if (amountResult is AmountResult.Invalid) {
            state = state.copy(
                error = amountResult.errorMessage
            )
        } else {
            state = state.copy(
                isLoading = true,
                error = ""
            )
            viewModelScope.launch {
                try {
//                    addTipUseCase(Tip(id, amount = state.tipAmount.toDouble(), date = state.date))
                    addTipUseCase(
                        Tip(
                            id,
                            amount = state.tipAmount.toDouble(),
                            date = LocalDate.parse(
                                state.date,
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")
                            )
                        )
                    )
                    state = state.copy(
                        showToast = true
                    )
                } catch (e: Exception) {
                    println()
                }

                println()
            }
        }
        state = state.copy(
            isLoading = false,
            showToast = false
        )


    }

    private fun getCurrentDate() {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val current = LocalDateTime.now().format(formatter)
        state = state.copy(
            date = current
        )
    }

    fun formatDate(date: String): String {
        val instant = Instant.ofEpochMilli(date.toLong()).atZone(ZoneId.of("UTC")).toLocalDate()
        val day: String =
            if (instant.dayOfMonth >= 10) instant.dayOfMonth.toString() else "0${instant.dayOfMonth}"
        val month: String =
            if (instant.monthValue >= 10) instant.monthValue.toString() else "0${instant.monthValue}"
        return "$day/$month/${instant.year}"
    }
}