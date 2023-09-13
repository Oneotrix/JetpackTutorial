package com.dipom.state

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.state.ui.theme.JetpackTutorialTheme

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {
    val count = 0
    Text(
        text = "You've have $count glasses.",
        modifier = modifier.padding(16.dp)
    )
}


@Preview
@Composable
fun WaterCounterPreview() {
    JetpackTutorialTheme {
        WaterCounter()
    }
}