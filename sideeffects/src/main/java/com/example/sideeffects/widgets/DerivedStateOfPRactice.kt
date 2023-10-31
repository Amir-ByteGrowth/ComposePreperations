package com.example.sideeffects.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckForDerivedStates() {
    var counter by remember { mutableStateOf(0) }
    var evenOdd by remember { mutableStateOf("Odd") }

    evenOdd = if (counter % 2 == 0) "Even" else "Odd"

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Counter  $counter")
        Text(text = "EvenOdd $evenOdd")
        Button(onClick = { counter++ }) {
            Text(text = "Add")
        }
    }

}


@Composable
fun DerivedStateExample() {

    var counter by remember { mutableStateOf(0) }

    val evenOdd by remember {
        derivedStateOf {
            if (counter % 2 == 0) "even"
            else "odd"
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "$counter", fontSize = 30.sp)
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
        )
        Text(text = "count is $evenOdd", fontSize = 30.sp)
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
        )
        Button(onClick = {
            counter++
        }) {
            Text(text = "Counter")
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DerivedStateOfExample() {

    var numberOne by remember { mutableStateOf(0) }
    var numberTwo by remember { mutableStateOf(0) }
    val result by remember { derivedStateOf { numberOne + numberTwo } }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(value = "$numberOne", onValueChange = { numberOne = it.toIntOrNull() ?: 0 })
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
        )
        TextField(value = "$numberTwo", onValueChange = { numberTwo = it.toIntOrNull() ?: 0 })
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
        )
        Text(text = "Result is : $result", fontSize = 30.sp)
    }

}

