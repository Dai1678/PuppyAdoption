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
package dev.dai.puppyadoption.data

import androidx.annotation.DrawableRes
import dev.dai.puppyadoption.R

data class Puppy(
    val id: Int,
    val name: String,
    @DrawableRes val imageResId: Int,
    val age: Int,
    val description: String,
)

val samplePuppyList = listOf(
    Puppy(
        id = 0,
        name = "Ariel",
        imageResId = R.drawable.ariel,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        id = 1,
        name = "Blossom",
        imageResId = R.drawable.blossom,
        age = 3,
        description = "Fantastic!"
    ),
    Puppy(
        id = 2,
        name = "Candy",
        imageResId = R.drawable.candy,
        age = 4,
        description = "Excellent!"
    ),
    Puppy(
        id = 3,
        name = "Daisy",
        imageResId = R.drawable.daisy,
        age = 6,
        description = "Perfect!"
    ),
    Puppy(
        id = 4,
        name = "Emmy",
        imageResId = R.drawable.emmy,
        age = 8,
        description = "Brilliant!"
    ),
    Puppy(
        id = 5,
        name = "Grace",
        imageResId = R.drawable.grace,
        age = 2,
        description = "Amazing!"
    ),
    Puppy(
        id = 6,
        name = "Honey",
        imageResId = R.drawable.honey,
        age = 9,
        description = "Cool!"
    ),
    Puppy(
        id = 7,
        name = "Jewel",
        imageResId = R.drawable.jewel,
        age = 10,
        description = "Awesome!"
    )
)
