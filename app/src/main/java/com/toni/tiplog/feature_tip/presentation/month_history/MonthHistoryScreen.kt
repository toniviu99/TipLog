package com.toni.tiplog.feature_tip.presentation.month_history

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toni.tiplog.R
import com.toni.tiplog.core.presentation.TipLogCircularProgress
import com.toni.tiplog.core.presentation.TipLogNoTips
import com.toni.tiplog.feature_tip.presentation.month_history.components.MonthItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MonthHistoryScreen(
    onTipHistory: (String) -> Unit,
    viewModel: MonthHistoryViewModel = hiltViewModel()
) {
    var state = viewModel.state

    Scaffold {
        if (state.isLoading){
            TipLogCircularProgress()
        } else if (state.months.isEmpty()){
            TipLogNoTips()
        } else{
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 18.dp, end = 18.dp, top = 50.dp)) {
                Text(text = stringResource(R.string.history), color = Color.Black)
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(state.months){
                        MonthItem(month = it){
                            onTipHistory(it.month)
                        }
                    }
                }
            }

        }
    }
}