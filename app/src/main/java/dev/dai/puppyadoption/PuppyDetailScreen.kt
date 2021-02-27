package dev.dai.puppyadoption

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
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
            // TODO
        }
    }
}