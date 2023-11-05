package com.example.stateincmposecodelab.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateincmposecodelab.data.WellnessItem
import com.example.stateincmposecodelab.data.getWellnessList


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessItem> = remember { getWellnessList() }
) {



    LazyColumn(
        modifier = modifier,
       state = rememberLazyListState()
    ) {
        items(list) { item -> WellnessTaskItem(taskName = item.name) }
    }
}

@Composable
fun WellnessTaskItem(taskName: String, modifier: Modifier = Modifier) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckChanged = { newValue -> checkedState = newValue },
        onClose = {}, // we will implement this later!
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


@Preview
@Composable
fun PreviewItem() {
    WellnessTaskItem("FirstItem", false, { checked -> }, {})
}