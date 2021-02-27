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
import dev.dai.puppyadoption.ui.theme.MyTheme

@Composable
fun PuppyDetailScreen() {
    MyTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(stringResource(R.string.app_name))
                })
            }
        ) {
            PuppyDetail()
        }
    }
}

@Composable
private fun PuppyDetail() {
    val image = painterResource(R.drawable.ariel)
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
            text = "Ariel",
            style = MaterialTheme.typography.h4
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Age: 10",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Description",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Cute!",
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
private fun PuppyDetailPreview() {
    MyTheme {
        Surface {
            PuppyDetail()
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        PuppyDetailScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetailScreen()
    }
}
