package com.example.composepreperations.widgets.statepractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var textData by remember {
        mutableStateOf("")
    }
    var showData by remember {
        mutableStateOf(false)
    }

    var rememberTextData by remember{ mutableStateOf("") }
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Button(onClick = {
            rememberTextData = textData
            showData = true
        }) {
            Text(text = "Show Text")
        }

        OutlinedTextField(value = textData, onValueChange = { textData = it },
            label = { Text(text = "write here") })


        showEditTextData(textData = rememberTextData, showData)

    }
}


@Composable
fun showEditTextData(textData: String, showData: Boolean) {
    if (showData)
        Text(text = textData)
}


@Composable
fun incrementData(counter: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Click to Add Value in $counter")
    }

}

