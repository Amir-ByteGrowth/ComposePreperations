package com.example.sideeffects.widgets

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SideEffectFreeWidget() {
    // Define a state variable for the count
    val count = remember { mutableStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        Log.d("Amir", "Count is ${count.value}")
    }

    Column {
        Button(onClick = { count.value++ }) {
            Text("Counter ${count.value}")

        }

        // With every state update, text is changed and recomposition is triggered

    }
}