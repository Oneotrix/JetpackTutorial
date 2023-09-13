package com.dipom.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.state.ui.theme.JetpackTutorialTheme

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.padding(16.dp)) {
        val count: MutableState<Int> = remember {mutableStateOf(0)}
        Text(
            text = "You've have ${count.value} glasses."
        )
        Button(
            onClick = { count.value ++},
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }
    }

}


@Preview
@Composable
fun WaterCounterPreview() {
    JetpackTutorialTheme {
        WaterCounter()
    }
}