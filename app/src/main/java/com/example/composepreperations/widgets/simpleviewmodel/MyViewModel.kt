package com.example.composepreperations.widgets.simpleviewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _name = MutableLiveData("amir")
    val name: LiveData<String>
        get() = _name

    private val _uiState = mutableStateOf("")
    val uiState: State<String>
        get() = _uiState


    fun setName(name: String) {
        _name.value = name
        Log.d("ViewModelMethod",this.name.value.toString())
    }

}