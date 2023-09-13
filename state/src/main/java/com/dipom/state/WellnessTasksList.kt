package com.dipom.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.dipom.state.data.WellnessTask

private fun getWellnessTasks() = List(30) {i -> WellnessTask(i, "Task #$i")}


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = rememberSaveable { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
              WellnessTaskItemStateful(
                  taskName = task.label,
                  onClose = {  }
              )
        }
    }
}