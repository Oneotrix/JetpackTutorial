package com.dipom.jetpacktutorial

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.jetpacktutorial.ui.theme.JetpackTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(com.dipom.jetpacktutorial.models.Message
                        ("Android",
                        "Jetpack Compose"))
                }
            }
        }
    }
}

@Composable
fun MessageCard(msg: com.dipom.jetpacktutorial.models.Message) {
    Row {
        Image(  painter = painterResource(id = R.drawable.photo),
                contentDescription = "Maks photo",
                modifier = Modifier
                    //set size
                    .size(40.dp)
                    //clip to circle
                    .clip(CircleShape)
        )
    
        Spacer(modifier = Modifier.width(10.dp))
    
        Column() {
            Text(text = msg.author)
            
            Spacer(modifier = Modifier.height(5.dp))
            
            Text(text = msg.body)
         }
    }
}

@Preview
@Composable
fun PrevMessageCard() {
    JetpackTutorialTheme {
        Surface {
            MessageCard(com.dipom.jetpacktutorial.models.Message("Maks", "Hello world"))
        }
    }
}