package com.example.stateincmposecodelab.wellnessscreenwithviewmodel

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.stateincmposecodelab.data.WellnessItem
import com.example.stateincmposecodelab.data.getWellnessList

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessList().toMutableStateList()
    val task: List<WellnessItem>
        get() = _tasks

    fun removeTask(wellnessItem: WellnessItem){
        _tasks.remove(wellnessItem)
    }

    fun changeTaskChecked(item: WellnessItem, checked: Boolean) =
        task.find { it.id == item.id }?.let { task ->
            task.checked.value = checked
            Log.d("OnCheckedChanged",item.toString())
        }

}