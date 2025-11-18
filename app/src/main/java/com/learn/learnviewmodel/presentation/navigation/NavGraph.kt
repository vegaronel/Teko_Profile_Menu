package com.learn.learnviewmodel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.learnviewmodel.presentation.ui.screens.accountMenu.AccountMenuScreen
import com.learn.learnviewmodel.presentation.ui.screens.accountMenu.TrendsScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {
        composable(NavRoutes.Home.route) {
            AccountMenuScreen(
                onPerformanceClick = {
                    navController.navigate(NavRoutes.TrendsScreen.route)
                },
                onMapClick = { /* navigate to Map screen if exists */ }
            )
        }

        composable(NavRoutes.TrendsScreen.route) {
            TrendsScreen(
                onBack = { navController.popBackStack() } // this allows the back button to work
            )
        }
    }
}
