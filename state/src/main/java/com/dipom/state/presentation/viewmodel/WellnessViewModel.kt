package com.dipom.state.presentation.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.dipom.state.data.WellnessTask

private fun getWellnessTasks() = List(30) {i -> WellnessTask(i, "Task #$i") }

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

}
