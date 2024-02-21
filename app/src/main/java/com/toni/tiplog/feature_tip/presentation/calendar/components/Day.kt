package com.toni.tiplog.feature_tip.presentation.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kizitonwose.calendar.core.CalendarDay
import com.toni.tiplog.ui.theme.Primary
import com.toni.tiplog.ui.theme.White
import java.time.LocalDate

@Composable
fun Day(
    day: CalendarDay,
    isSelected: Boolean
) {
    val fechaActual: LocalDate = LocalDate.now()
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(color = if (day.date == fechaActual) Primary else White),
        // This is important for square sizing!
        contentAlignment = Alignment.Center
    ) {
        Text(text = day.date.dayOfMonth.toString())

    }
}