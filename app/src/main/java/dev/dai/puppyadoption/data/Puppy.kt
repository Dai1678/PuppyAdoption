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

import android.os.Parcelable
import androidx.annotation.DrawableRes
import dev.dai.puppyadoption.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    @DrawableRes val imageResId: Int,
    val age: Int,
    val description: String
) : Parcelable

val samplePuppyList = listOf(
    Puppy(
        name = "Ariel",
        imageResId = R.drawable.ariel,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        name = "Blossom",
        imageResId = R.drawable.blossom,
        age = 3,
        description = "Fantastic!"
    ),
    Puppy(
        name = "Candy",
        imageResId = R.drawable.candy,
        age = 4,
        description = "Excellent!"
    ),
    Puppy(
        name = "Daisy",
        imageResId = R.drawable.daisy,
        age = 6,
        description = "Perfect!"
    ),
    Puppy(
        name = "Emmy",
        imageResId = R.drawable.emmy,
        age = 8,
        description = "Brilliant!"
    ),
    Puppy(
        name = "Grace",
        imageResId = R.drawable.grace,
        age = 2,
        description = "Amazing!"
    ),
    Puppy(
        name = "Honey",
        imageResId = R.drawable.honey,
        age = 9,
        description = "Cool!"
    ),
    Puppy(
        name = "Jewel",
        imageResId = R.drawable.jewel,
        age = 10,
        description = "Awesome!"
    )
)
