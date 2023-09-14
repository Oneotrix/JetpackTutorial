package com.dipom.state.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(
    val id: Int,
    val label: String,
    var initialChecked: MutableState<Boolean> = mutableStateOf(false)
){
    var checked by mutableStateOf(initialChecked)
}