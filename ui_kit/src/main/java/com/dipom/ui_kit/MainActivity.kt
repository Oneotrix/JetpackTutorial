package com.dipom.ui_kit

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipom.ui_kit.data.AlignYourBodyData
import com.dipom.ui_kit.data.FavoriteCollectionsData
import com.dipom.ui_kit.ui.theme.JetpackTutorialTheme
import java.util.logging.Logger

class MainActivity : ComponentActivity() {
    //@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = LocalConfiguration.current
            //val windowSizeClass = calculateWindowSizeClass(activity = this)
            MyApp(configuration)
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
            containerColor = MaterialTheme.colorScheme.onPrimary
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

@Composable
fun FavoriteCollectionGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)) {
        items(FavoriteCollectionsData.list) { item ->
            FavoriteCollectionCard(
                image = item.drawable,
                text = item.string,
                modifier = modifier.height(80.dp)
            )
        }
    }
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit) {

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(modifier = modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun MyButtonNavigation(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppPortrait() {
    JetpackTutorialTheme() {
        Scaffold(
            bottomBar = { MyButtonNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
private fun MyAppNavigationRail(
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null)
                },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null)
                },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}

@Composable
fun MyAppLandscape() {
    JetpackTutorialTheme() {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                MyAppNavigationRail()
                HomeScreen()
            }
        }
    }

}

@Composable
fun MyApp(configuration: Configuration) {
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            MyAppLandscape()
        }
        Configuration.ORIENTATION_PORTRAIT -> {
            MyAppPortrait()
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

@Preview(
    showBackground = true
)
@Composable
fun FavoriteCollectionGridPreview() {
    JetpackTutorialTheme {
        FavoriteCollectionGrid()
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
@Composable
fun HomeSectionPreview() {
    JetpackTutorialTheme() {
            HomeSection(
                title = R.string.align_your_body) {
                AlignYourBodyRow()
            }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
@Composable
fun HomeScreenPreview() {
    JetpackTutorialTheme {
        HomeScreen()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE,
)
@Composable
fun MyButtonNavigationPreview() {
    JetpackTutorialTheme {
        MyButtonNavigation()
    }
}


@Preview
@Composable
fun MyAppPortraitPreview() {
    JetpackTutorialTheme {
        MyAppPortrait()
    }
}

@Preview
@Composable
fun MyAppNavigationRailPreview() {
    JetpackTutorialTheme {
        MyAppNavigationRail()
    }
}

@Preview()
@Composable
fun MyAppLandscapePreview() {
    JetpackTutorialTheme {
       MyAppLandscape()
    }

}