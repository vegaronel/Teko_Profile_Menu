package com.learn.learnviewmodel.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NextButton(onClick: () -> Unit) {
    Button(onClick = {
        onClick()
    }) {
        Text("To Profile, Delete After")
    }
}