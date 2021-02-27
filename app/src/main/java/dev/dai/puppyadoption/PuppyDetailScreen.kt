package dev.dai.puppyadoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.puppyadoption.data.Puppy
import dev.dai.puppyadoption.ui.theme.MyTheme

@Composable
fun PuppyDetailScreen(puppy: Puppy) {
    MyTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(stringResource(R.string.app_name))
                })
            }
        ) {
            PuppyDetail(puppy)
        }
    }
}

@Composable
private fun PuppyDetail(puppy: Puppy) {
    val image = painterResource(puppy.imageResId)
    Column(
        Modifier.padding(16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.height(220.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Age: ${puppy.age}",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Description",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = puppy.description,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
private fun PuppyDetailPreview() {
    MyTheme {
        Surface {
            PuppyDetail(
                Puppy(
                    name = "Ariel",
                    imageResId = R.drawable.ariel,
                    age = 10,
                    description = "Cute!"
                )
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        PuppyDetailScreen(
            Puppy(
                name = "Ariel",
                imageResId = R.drawable.ariel,
                age = 10,
                description = "Cute!"
            )
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetailScreen(
            Puppy(
                name = "Ariel",
                imageResId = R.drawable.ariel,
                age = 10,
                description = "Cute!"
            )
        )
    }
}
