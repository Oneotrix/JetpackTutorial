package com.dipom.state.data

data class WellnessTask(
    val id: Int,
    val label: String,
    var checked: Boolean = false
)
