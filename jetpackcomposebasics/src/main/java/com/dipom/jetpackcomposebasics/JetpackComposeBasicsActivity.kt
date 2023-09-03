package com.dipom.jetpackcomposebasics

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.jetpackcomposebasics.ui.theme.JetpackTutorialTheme

class JetpackComposeBasicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTutorialTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Surface(color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
    {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f))
            {
                Text(text = "Hello, ")
                Text(text = name)
            }

            ElevatedButton(onClick = { },
                   shape = MaterialTheme.shapes.medium) {
                Text(text = "Show more")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackTutorialTheme {
        Greeting("Android")
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier,
                  names: List<String> = listOf("World", "Compose")) {

        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for(name in names) {
                Greeting(name = name)
            }
        }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun PrevMyApp() {
    JetpackTutorialTheme {
        MyApp()
    }
}