package com.dipom.state.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.dipom.state.data.WellnessTask

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        StatefulCounter(modifier = modifier)

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTaskList(
            list = list,
            onClouseTask = {task -> list.remove(task)}
        )
    }
}

private fun getWellnessTasks() = List(30) {i -> WellnessTask(i, "Task #$i") }
