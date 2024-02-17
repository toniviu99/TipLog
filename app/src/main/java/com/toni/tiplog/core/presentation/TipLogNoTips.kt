package com.toni.tiplog.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TipLogNoTips() {
    Box(
        modifier = Modifier.fillMaxSize(), 
        contentAlignment = Alignment.Center
    ) {
        Text(text = "No tips found", color = Color.Black)
    }
}