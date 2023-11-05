package com.example.stateincmposecodelab.data

data class WellnessItem(val id: Int, val name: String)

fun getWellnessList() = List(100) { i -> WellnessItem(i, "Task # $i") }