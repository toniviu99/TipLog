package com.toni.tiplog.feature_tip.presentation.tip_history.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toni.tiplog.R
import com.toni.tiplog.core.presentation.TipLogDialogAlert
import com.toni.tiplog.feature_tip.domain.model.Tip
import com.toni.tiplog.feature_tip.presentation.tip_history.TipHistoryEvent
import com.toni.tiplog.feature_tip.presentation.tip_history.TipHistoryViewModel
import com.toni.tiplog.ui.theme.TipLogRed

@Composable
fun TipItem(
    tip: Tip,
    deleteTip: () -> Unit,
) {

    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp, top = 5.dp)
            .shadow(7.dp, shape = RoundedCornerShape(15.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(18.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(text = tip.date.toString(), color = Color.Black, fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "${tip.amount} €", color = Color.Black, fontSize = 20.sp)
                }
                OutlinedButton(
                    onClick = { showDialog = true },
                    border = BorderStroke(1.dp, TipLogRed),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = TipLogRed
                    )
                ) {
                    Text(text = stringResource(R.string.delete_button), color = Color.Red)
                }
            }
            if (showDialog) {
                TipLogDialogAlert(
                    title = stringResource(R.string.title_dialog),
                    desc = stringResource(R.string.text_dialog),
                    onDismiss = { showDialog = false }) {
                    deleteTip()
                }
            }
        }
    }
}

