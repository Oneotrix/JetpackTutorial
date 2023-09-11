package com.dipom.ui_kit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.ui_kit.data.AlignYourBodyData
import com.dipom.ui_kit.ui.theme.JetpackTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = "Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )

}

@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier,
    image: Int,
    text: Int) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(text = stringResource(id = R.string.adb1_inversions),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes image: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(painter = painterResource(
                id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
    
    
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(
            AlignYourBodyData.list
        ) {
            AlignYourBodyElement(
                image = it.drawable,
                text = it.string)
        }
    }
}

/*

Preview Section

*/

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
@Composable
fun SearchBarPreview() {
    JetpackTutorialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            SearchBar(modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
@Composable
fun AlignYourBodyElementPreview() {
    JetpackTutorialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            AlignYourBodyElement(
                image = R.drawable.ab1_inversions,
                text = R.string.nature_meditation
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    JetpackTutorialTheme {
        FavoriteCollectionCard(
            text = R.string.nature_meditation,
            image = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
@Composable
fun AlignYourBodyRowPreview() {
    JetpackTutorialTheme {
        AlignYourBodyRow()
    }
}
