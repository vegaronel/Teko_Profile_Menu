package com.learn.learnviewmodel.presentation.navigation

sealed class NavRoutes(val route : String) {
    object Home : NavRoutes("home")
    object Profile : NavRoutes("profile")
    object TrendsScreen : NavRoutes("trendsScreen")
}