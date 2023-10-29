package com.example.sideeffects.widgets

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class ApiState<out T> {
    data class Success<T>(val data: String) : ApiState<T>()
    object Loading : ApiState<Nothing>()
    object Empty : ApiState<Nothing>()
}

class MainViewModel : ViewModel() {
    private val _apiState: MutableState<ApiState<String>> = mutableStateOf(ApiState.Empty)
    var apiState: State<ApiState<String>> = _apiState
        private set

    fun getApiData() = viewModelScope.launch {
        _apiState.value = ApiState.Loading
        delay(2000)
        _apiState.value = ApiState.Success("Data loaded successfully..")
    }

}

@Composable
fun LaunchEffectWithApiCalling() {
    val viewModel by remember {
        mutableStateOf(MainViewModel())
    }
    var call by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = call) {

        viewModel.getApiData()
    }
    Column {
        Button(onClick = { call = !call }) {
            Text(text = "Click Here")
        }
        when (val res = viewModel.apiState.value) {
            is ApiState.Success -> {
                Log.d("main", "Success")
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = res.data, fontSize = 25.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {
                        call = !call
                    }) {
                        Text(text = "Call Api again !")
                    }
                }
            }

            ApiState.Loading -> {
                Log.d("main", "Loading")
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            ApiState.Empty -> {}
        }
    }

    // never call this function here as whenever recomposition occurs this function will call again
//    viewModel.getApiData()


}