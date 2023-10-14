package com.example.composepreperations.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(title: String, onBackPressed: () -> Unit) {

    TopAppBar(title = {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(
                    Alignment.Center
                )
        )
    },
        navigationIcon = {
            IconButton(onClick = {onBackPressed.invoke()}) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "localizedString"
                )
            }
        }

    )
}