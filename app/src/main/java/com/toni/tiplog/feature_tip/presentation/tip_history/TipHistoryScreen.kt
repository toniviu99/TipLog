package com.toni.tiplog.feature_tip.presentation.tip_history

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toni.tiplog.core.presentation.TipLogCircularProgress
import com.toni.tiplog.core.presentation.TipLogNoTips
import com.toni.tiplog.feature_tip.presentation.tip_history.components.TipItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TipHistoryScreen(
    viewModel: TipHistoryViewModel = hiltViewModel(),
    goBack: () -> Unit
) {
    var state = viewModel.state
    Scaffold {
        if (state.isLoading) {
            TipLogCircularProgress()
        } else {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 18.dp, end = 18.dp, top = 50.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    tint = Color.Black,
                    modifier = Modifier.clickable {
                        goBack()
                    }
                )
                if (state.tips.isEmpty()) {
                    TipLogNoTips()
                } else {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "HISTORY", color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.tips) {
                            TipItem(
                                tip = it,
                                deleteTip = {
                                    viewModel.onEvent(TipHistoryEvent.DeleteTip(it))
                                }
                            )
                        }
                    }
                }


            }

        }
    }
}