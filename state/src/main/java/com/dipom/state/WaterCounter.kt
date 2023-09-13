package com.dipom.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.state.ui.theme.JetpackTutorialTheme

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0)}
        if(count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if(showTask) {
//                WellnessTaskItem(
//                    taskName = "Have you taken your 15 minute walk today?",
//                    onClose = { showTask = false}
//                )
//            }
            Text(text = "You've had $count glasses.")
        }

        Button(
                onClick = { count ++},
                enabled = count < 10,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = "Add one")
            }
//        Row(modifier = Modifier.padding(top = 8.dp)) {
//            Button(
//                onClick = { count ++},
//                enabled = count < 10
//            ) {
//                Text(text = "Add one")
//            }
//
//            Button(
//                onClick = {count = 0},
//                enabled = count > 0,
//                modifier = Modifier.padding(start = 8.dp)
//            ) {
//                Text(text = "Clear water count")
//            }
//
//        }
        
    }
}


@Composable
fun StatelessCounter(
    counter: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    if(counter > 0) {
        Text(text = "You've had $counter glasses.")
    }

    Button(
        onClick = onIncrement,
        enabled = counter < 10,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(text = "Add one")
    }
}


@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(counter = count, onIncrement = { count++}, modifier)
}

@Preview
@Composable
fun WaterCounterPreview() {
    JetpackTutorialTheme {
        WaterCounter()
    }
}