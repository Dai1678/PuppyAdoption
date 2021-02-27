package dev.dai.puppyadoption.data

import androidx.annotation.DrawableRes

data class Puppy(
    val name: String,
    @DrawableRes val imageResId: Int,
    val age: Int,
    val description: String
)
