package com.toni.tiplog.navigation.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
){
    NEW_TIP(
        "New Tip",
        Icons.Filled.Add,
        Icons.Outlined.Add,
        Screens.NewTipScreen.name
    ),
    CALENDAR(
        "Calendar",
        Icons.Filled.DateRange,
        Icons.Outlined.DateRange,
        Screens.CalendarScreen.name
    ),
    HISTORY(
        "History",
        Icons.Filled.List,
        Icons.Outlined.List,
        Screens.HistoryScreen.name
    ),

}
