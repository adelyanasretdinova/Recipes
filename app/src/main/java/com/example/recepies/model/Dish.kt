package com.example.recepies.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Dish(
    val image: String = "",
    val id: String = "",
    val name: String = "",
    val ingredients: String = "",
    val description: String = ""
)
