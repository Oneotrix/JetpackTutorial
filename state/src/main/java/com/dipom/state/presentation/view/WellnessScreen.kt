package com.dipom.state.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dipom.state.data.WellnessTask
import com.dipom.state.presentation.viewmodel.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier) {
        StatefulCounter(modifier = modifier)

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onClouseTask = {task -> wellnessViewModel.remove(task)}
        )
    }
}

