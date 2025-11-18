package com.learn.learnviewmodel.presentation.navigation

sealed class NavRoutes(val route : String) {
    object Home : NavRoutes("home")
    object TrendsScreen : NavRoutes("trendsScreen")
}