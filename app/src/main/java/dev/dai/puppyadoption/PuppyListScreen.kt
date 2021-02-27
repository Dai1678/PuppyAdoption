package dev.dai.puppyadoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.puppyadoption.data.Puppy
import dev.dai.puppyadoption.ui.theme.MyTheme

@Composable
fun PuppyItem(puppy: Puppy) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val img = painterResource(id = puppy.imageResId)
        Image(
            painter = img,
            contentDescription = null,
            modifier = Modifier.size(56.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.width(16.dp))
        Text(puppy.name)
    }
}

@Preview
@Composable
fun PuppyItemPreview() {
    MyTheme {
        Surface {
            PuppyItem(
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
