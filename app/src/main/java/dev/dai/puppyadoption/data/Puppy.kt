package dev.dai.puppyadoption.data

import androidx.annotation.DrawableRes
import dev.dai.puppyadoption.R

data class Puppy(
    val name: String,
    @DrawableRes val imageResId: Int,
    val age: Int,
    val description: String
)

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
        description = "Cute!"
    ),
    Puppy(
        name = "Candy",
        imageResId = R.drawable.candy,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        name = "Daisy",
        imageResId = R.drawable.daisy,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        name = "Emmy",
        imageResId = R.drawable.emmy,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        name = "Grace",
        imageResId = R.drawable.grace,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        name = "Honey",
        imageResId = R.drawable.honey,
        age = 10,
        description = "Cute!"
    ),
    Puppy(
        name = "Jewel",
        imageResId = R.drawable.jewel,
        age = 10,
        description = "Cute!"
    )
)
