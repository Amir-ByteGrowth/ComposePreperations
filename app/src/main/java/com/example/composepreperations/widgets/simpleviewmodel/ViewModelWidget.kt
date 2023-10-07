package com.example.composepreperations.widgets.simpleviewmodel

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewModelWidget( myName:String,viewModel: MyViewModel= MyViewModel()) {
    var nameVal by rememberSaveable {
        mutableStateOf("")
    }

    Column (verticalArrangement =  Arrangement.spacedBy(10.dp)){
        OutlinedTextField(value = nameVal,
            onValueChange = { nameVal = it },
            label = { Text(text = "Enter Name here") }
        )
        Row(horizontalArrangement = Arrangement.spacedBy(50.dp)) {
            Button(onClick ={ viewModel.setName(nameVal)},
                modifier = Modifier.padding(all = Dp(10F)),

                // below line is use to set or
                // button as enable or disable.
                enabled = true,

                // below line is use to
                // add border to our button.
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

                // below line is use to add shape for our button.
                shape = MaterialTheme.shapes.medium,) {
                Text(text = "UpdateName", color = Color.White)
            }
            
            
            Text(text = viewModel.name.observeAsState().value.toString(),color = Color.Black)
            
        }
    }

}