package com.example.stateincmposecodelab.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class WellnessItem(val id: Int, val name: String,var checked: MutableState<Boolean> = mutableStateOf(false))

fun getWellnessList() = List(100) { i -> WellnessItem(i, "Task # $i") }