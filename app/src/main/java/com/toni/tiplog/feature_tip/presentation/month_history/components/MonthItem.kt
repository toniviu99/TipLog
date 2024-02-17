package com.toni.tiplog.feature_tip.presentation.month_history.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toni.tiplog.feature_tip.domain.model.MonthAmount

@Composable
fun MonthItem(
    month: MonthAmount,
    onTipHistory: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
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
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "MONTH:")
                Text(text = month.month, color = Color.Black, fontSize = 22.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "MONTH AMOUNT:")
                        Text(text = "${month.totalAmount} €", color = Color.Black, fontSize = 22.sp)
                    }
                    Column {
                        Button(
                            onClick = {onTipHistory() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(90.dp)
                        ) {
                            Text(
                                text = "MORE INFO",
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                }
            }
        }
    }
}
