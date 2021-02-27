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
