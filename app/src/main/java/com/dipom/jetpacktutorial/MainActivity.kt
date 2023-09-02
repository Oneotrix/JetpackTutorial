package com.dipom.jetpacktutorial

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dipom.jetpacktutorial.ui.theme.JetpackTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(com.dipom.jetpacktutorial.models.Message
                ("Android",
                 "Jetpack Compose"))
        }
    }
}

@Composable
fun MessageCard(msg: com.dipom.jetpacktutorial.models.Message) {
    Text(text = msg.author)
    Text(text = msg.body)

}

@Preview
@Composable
fun PrevMessageCard() {
    MessageCard(com.dipom.jetpacktutorial.models.Message("Maks", "Hello world"))
}