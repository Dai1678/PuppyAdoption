/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.dai.puppyadoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
fun PuppyListScreen(actionToPuppyDetail: (Puppy) -> Unit) {
    MyTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(R.string.app_name))
                    }
                )
            }
        ) {
            LazyColumn {
                items(samplePuppyList) { puppy ->
                    PuppyItem(puppy) { actionToPuppyDetail(puppy) }
                    Divider()
                }
            }
        }
    }
}

@Composable
private fun PuppyItem(puppy: Puppy, onClickRow: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClickRow() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(puppy.imageResId),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(56.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = puppy.name,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun PuppyItemPreview() {
    MyTheme {
        Surface {
            PuppyItem(
                puppy = Puppy(
                    id = 0,
                    name = "Ariel",
                    imageResId = R.drawable.ariel,
                    age = 10,
                    description = "Cute!"
                ),
                onClickRow = {}
            )
        }
    }
}

@Preview("PuppyListScreen", widthDp = 360, heightDp = 640)
@Composable
private fun PuppyListScreenPreview() {
    MyTheme {
        PuppyListScreen(actionToPuppyDetail = {})
    }
}
