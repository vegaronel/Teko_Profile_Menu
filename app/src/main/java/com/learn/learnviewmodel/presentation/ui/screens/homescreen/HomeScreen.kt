package com.learn.learnviewmodel.presentation.ui.screens.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.learn.learnviewmodel.presentation.navigation.NavRoutes

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        Text("Home Screen")
        Button(onClick = {
            navController.navigate(NavRoutes.Details.route)
        }) {
            Text("To Details")
        }
    }
}