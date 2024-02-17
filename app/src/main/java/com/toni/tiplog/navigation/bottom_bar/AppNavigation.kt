package com.toni.tiplog.navigation.bottom_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.toni.tiplog.feature_tip.presentation.calendar.CalendarScreen
import com.toni.tiplog.feature_tip.presentation.month_history.MonthHistoryScreen
import com.toni.tiplog.feature_tip.presentation.tip.TipScreen
import com.toni.tiplog.feature_tip.presentation.tip_history.TipHistoryScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                NavItem.values().forEach { navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.selectedIcon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = navItem.title)
                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.NewTipScreen.name,
            modifier = Modifier
                .padding(it)
        ) {
            composable(route = Screens.NewTipScreen.name) {
                TipScreen()
            }
            composable(route = Screens.CalendarScreen.name) {
                CalendarScreen()
            }
            composable(route = Screens.HistoryScreen.name) {
                MonthHistoryScreen(onTipHistory = {
                    navController.navigate(Screens.TipHistoryScreen.name + "?month=$it")
                })
            }
            composable(
                route = Screens.TipHistoryScreen.name + "?month={month}",
                arguments = listOf(navArgument("month") {
                    type = NavType.StringType
                })

            ) {
                TipHistoryScreen(goBack = {
                    navController.navigate(Screens.HistoryScreen.name)
                } )
            }

        }
    }
}

