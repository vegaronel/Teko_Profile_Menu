package com.learn.learnviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.learnviewmodel.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingPreview(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview(modifier: Modifier = Modifier) {
    Column {
        Box(
            modifier = modifier
                .size(200.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text("Hello Kotlin")
        }
        Box(
            modifier = modifier
                .size(200.dp)
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            Text("Hello Kotlin")
        }
        Box(
            modifier = modifier
                .size(200.dp)
                .background(MaterialTheme.colorScheme.error)
        ) {
            Text("Hello Kotlin")
        }
    }
}