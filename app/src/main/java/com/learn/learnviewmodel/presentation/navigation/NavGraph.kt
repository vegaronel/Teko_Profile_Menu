package com.learn.learnviewmodel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.learnviewmodel.presentation.ui.screens.detailsscreen.DetailsScreen
import com.learn.learnviewmodel.presentation.ui.screens.homescreen.HomeScreen

@Composable
fun NavGraph(modifier : Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(modifier = modifier, navController = navController, startDestination = NavRoutes.Home.route, builder = {
        composable(NavRoutes.Home.route) {
            HomeScreen(navController)
        }
        composable(route = NavRoutes.Details.route) {
            DetailsScreen()
        }
    })

}