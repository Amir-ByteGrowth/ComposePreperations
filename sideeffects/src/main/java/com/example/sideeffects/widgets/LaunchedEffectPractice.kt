package com.example.sideeffects.widgets

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


private var i = 0

//side effect free
@Composable
fun LaunchedEffectP1() {
    var text by remember {
        mutableStateOf("text")
    }
    var text2 by remember {
        mutableStateOf("text")
    }

    LaunchedEffect(key1 = text) {
        Log.d("InsideLaunched", i.toString())
        i++
    }

    Column {
        Button(onClick = { text += "@" }) {

            Text(text = text)
        }

        Button(onClick = { text2 += "#" }) {

            Text(text = text2)
        }
    }

}


// composable with side effects

@Composable
fun ComposableSide1() {
    var text by remember {
        mutableStateOf("text")
    }



    Column {
        Button(onClick = { text += "@" }) {
            i++
            Log.d("ComposableWithSideEffect", i.toString())
            Text(text = text)
        }


    }

}