package com.example.recepies.remote

import com.example.recepies.DATABASE_URl
import com.example.recepies.model.Dish
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class DishesDataSource {
    suspend fun getProducts(): List<Dish> {
        val result = Firebase.database(DATABASE_URl)
            .getReference("/")
            .get()
            .await()

        return result.children.mapNotNull { it.getValue(Dish::class.java) }
    }
}
