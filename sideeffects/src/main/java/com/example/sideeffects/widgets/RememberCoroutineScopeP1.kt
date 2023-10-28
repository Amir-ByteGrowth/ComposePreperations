package com.example.sideeffects.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineP1() {
    val coroutineScope = rememberCoroutineScope()
    val data = remember { mutableStateOf("") }
    val data2 = remember { mutableStateOf("") }

    Column {
        Button(onClick = {
            coroutineScope.launch {
                // Simulate network call
                delay(2000)
                data.value += "Data loaded \n"
            }
        }) {
            Text("Load data")
        }

        Button(onClick = {
           data2.value +="#"
        }) {
            Text("Load data")
        }

        Text(text = data.value)
    }

}