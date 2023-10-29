package com.example.sideeffects.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun RememberUpdatedStatePractice() {
    var dynamicData by remember {
        mutableStateOf("amir")
    }
    LaunchedEffect(Unit) {
        delay(3000L)
        dynamicData = "New Text"
    }
    MyComponent(title = dynamicData)
}

@Composable
fun MyComponent(title: String) {
    var data by remember { mutableStateOf("") }

    val updatedData by rememberUpdatedState(title)

    LaunchedEffect(Unit) {
        delay(5000L)
        data = updatedData+ Calendar.getInstance().get(Calendar.SECOND)+"\n"
    }

    Text(text = data)
}