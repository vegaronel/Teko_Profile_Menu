package com.learn.learnviewmodel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.learnviewmodel.presentation.components.NextButton
import com.learn.learnviewmodel.presentation.ui.screens.accountMenu.AccountMenuScreen
import com.learn.learnviewmodel.presentation.ui.screens.accountMenu.TrendsScreen
import com.learn.learnviewmodel.presentation.ui.screens.homescreen.ProfileScreen

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
                onMapClick = { /* navigate to Map screen if exists */ },
                navController = navController
            )
        }

        composable(NavRoutes.TrendsScreen.route) {
            TrendsScreen(
                onBack = { navController.popBackStack() } // this allows the back button to work
            )
        }

        composable(NavRoutes.Profile.route) {
            ProfileScreen(
                onClick = { } // this allows the back button to work
            )
        }
    }
}
