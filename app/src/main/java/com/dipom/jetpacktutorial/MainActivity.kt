package com.dipom.jetpacktutorial

import android.content.res.Configuration
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.jetpacktutorial.data.SampleData
import com.dipom.jetpacktutorial.ui.theme.JetpackTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
//                    MessageCard(com.dipom.jetpacktutorial.models.Message
//                        ("Android",
//                        "Jetpack Compose"))
                    
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
}

@Composable
fun MessageCard(msg: com.dipom.jetpacktutorial.models.Message) {
    Row (modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = "Maks photo",
            modifier = Modifier
                //set size
                .size(40.dp)
                //clip to circle
                .clip(CircleShape)
                //add border
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Spacer(modifier = Modifier.height(5.dp))

        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )

            Surface(shape = MaterialTheme.shapes.large, shadowElevation = 3.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    //if the message is expanded, we display all its content
                    //otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
    }


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PrevMessageCard() {
    JetpackTutorialTheme {
        Surface {
            MessageCard(com.dipom.jetpacktutorial.models.Message("Maks", "Hello world"))
        }
    }
}

@Composable
fun Conversation(messages: List<com.dipom.jetpacktutorial.models.Message>) {
    LazyColumn {
        items(messages) {
            MessageCard(msg = it)
        }
    }
}

@Preview
@Composable
fun PrevConversation() {
    JetpackTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}