package com.toni.tiplog.feature_tip.presentation.tip

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TipViewModel @Inject constructor(

): ViewModel(){
    var state by mutableStateOf(TipState())
        private set

    fun onEvent(event: TipEvent){
        when(event){
            is TipEvent.TipChange -> {
                state = state.copy(
                    tipAmount = event.tipAmount
                )
            }
        }
    }
}