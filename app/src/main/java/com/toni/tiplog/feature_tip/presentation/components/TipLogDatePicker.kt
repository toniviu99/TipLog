package com.toni.tiplog.feature_tip.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipLogDatePicker(
    modifier: Modifier = Modifier,
    date: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .width(200.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(topStart = 90.dp, bottomStart = 90.dp))
            .clickable { onClick() },
        color = Color.White
    ){
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(date, color = Color.Black, fontSize = 22.sp)
        }
    }
}