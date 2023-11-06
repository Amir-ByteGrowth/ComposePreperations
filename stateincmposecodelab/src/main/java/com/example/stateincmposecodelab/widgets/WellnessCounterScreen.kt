package com.example.stateincmposecodelab.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessCounterScreen(modifier: Modifier = Modifier) {
    WellnessCounter(modifier)
}


@Composable
fun StateFullCounter() {
    Column {
        var count by remember { mutableStateOf(0) }
        StateLessCounter(count = count, { count++ })
//        var juiceCount by remember { mutableStateOf(0) }
//        StateLessCounter(count = juiceCount, { juiceCount++ })
    }

}

@Composable
fun StateLessCounter(count: Int, increment: () -> Unit, modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = increment, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }

}