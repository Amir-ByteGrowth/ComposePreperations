package com.example.stateincmposecodelab.wellnessscreenwithviewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stateincmposecodelab.R
import com.example.stateincmposecodelab.data.WellnessItem
import com.example.stateincmposecodelab.widgets.StateFullCounter


@Composable
fun WellnessScreenWithViewModel(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StateFullCounter()

        WellnessTaskList(wellnessItemList = wellnessViewModel.task,
            { task -> wellnessViewModel.removeTask(task) },
            { item, checked ->
                wellnessViewModel.changeTaskChecked(
                    item = item,
                    checked = checked
                )
            })

    }
}

@Composable
fun WellnessTaskList(
    wellnessItemList: List<WellnessItem>,
    removeItem: (wellnessItem: WellnessItem) -> Unit,
    onCheckChanged: (WellnessItem, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(wellnessItemList, key = { task -> task.id }) { item ->
            WellnessTaskItem(wellnessItem = item,
                { removeItem.invoke(item) }, { onCheckChanged.invoke(item, it) }
            )
            Divider(
                color = colorResource(id = R.color.teal_200)
            )
        }
    }
}


@Composable
fun WellnessTaskItem(
    wellnessItem: WellnessItem,
    onCloseTask: () -> Unit,
    onCheckChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {


    WellnessTaskItem(
        taskName = wellnessItem.name,
        checked = wellnessItem.checked.value,
        onCheckChanged = onCheckChanged,
        onClose = onCloseTask, // we will implement this later!
        modifier = modifier,
    )
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckChanged: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)

        )
        Checkbox(checked = checked, onCheckedChange = onCheckChanged)

        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Clear, contentDescription = "Close")
        }
    }
}
