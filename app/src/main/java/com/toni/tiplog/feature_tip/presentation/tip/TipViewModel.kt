package com.toni.tiplog.feature_tip.presentation.tip

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.domain.usecase.AddTipUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TipViewModel @Inject constructor(
    private val addTipUseCase: AddTipUseCase
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

            TipEvent.SaveTip -> saveTip()
        }
    }

    private fun saveTip() {
        val id = UUID.randomUUID().toString()
        state = state.copy(
            error = "",
            isLoading = true
        )
        if (state.tipAmount == "") {
            state = state.copy(
                error = "Vacio"
            )
        } else{
            viewModelScope.launch {
                try {
                    addTipUseCase(Tip(id, amount = state.tipAmount.toDouble(), date = state.date))
                } catch (e:Exception){
                    println()
                }

                println()
            }
        }
        state = state.copy(
            isLoading = false
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