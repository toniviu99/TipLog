package com.toni.tiplog.feature_tip.presentation.history

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.toni.tiplog.core.presentation.TipLogCircularProgress
import com.toni.tiplog.feature_tip.presentation.history.components.TipItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel()
) {
    var state = viewModel.state

    Scaffold {
        if (state.isLoading){
            TipLogCircularProgress()
        } else{
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.tips){
                    TipItem(tip = it)
                }
            }
        }
    }
}