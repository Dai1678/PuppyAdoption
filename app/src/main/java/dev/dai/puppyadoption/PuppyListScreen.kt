package dev.dai.puppyadoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.puppyadoption.data.Puppy
import dev.dai.puppyadoption.data.samplePuppyList
import dev.dai.puppyadoption.ui.theme.MyTheme

@Composable
fun PuppyListScreen(actionToPuppyDetail: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        MyTheme {
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(stringResource(R.string.app_name))
                    })
                }
            ) {
                LazyColumn {
                    items(samplePuppyList) { puppy ->
                        PuppyItem(puppy, actionToPuppyDetail)
                    }
                }
            }
        }
    }
}

@Composable
private fun PuppyItem(puppy: Puppy, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val img = painterResource(id = puppy.imageResId)
            Image(
                painter = img,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(56.dp, 56.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(16.dp))
            Text(puppy.name)
        }
        Divider()
    }
}

@Preview
@Composable
private fun PuppyItemPreview() {
    MyTheme {
        Surface {
            PuppyItem(
                puppy = Puppy(
                    name = "Ariel",
                    imageResId = R.drawable.ariel,
                    age = 10,
                    description = "Cute!"
                ),
                onClick = {}
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        PuppyListScreen(actionToPuppyDetail = {})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyListScreen(actionToPuppyDetail = {})
    }
}
