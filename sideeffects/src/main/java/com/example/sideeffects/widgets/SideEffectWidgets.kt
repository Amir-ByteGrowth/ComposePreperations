package com.example.sideeffects.widgets

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

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


@Composable
fun ToastSideEffectExample() {
    var counter by remember { mutableStateOf(0) }
    val context = LocalContext.current

    // on every recomposition , this toast will show
    Toast.makeText(context, "ShowToast", Toast.LENGTH_SHORT).show()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { counter++ }) {
            Text(text = "Click here")
        }

        Text(text = "$counter")
    }

}


@Composable
fun ToastSideEffectExampleWithLaunch() {
    var counter by remember { mutableStateOf(0) }
    val context = LocalContext.current

    // on every recomposition , this toast will show
    LaunchedEffect(key1 = true) {
        Toast.makeText(context, "ShowToast", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { counter++ }) {
            Text(text = "Click here")
        }

        Text(text = "$counter")
    }

}