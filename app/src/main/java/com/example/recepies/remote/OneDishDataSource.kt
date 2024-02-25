package com.example.recepies.remote

import com.example.recepies.DATABASE_URl
import com.example.recepies.model.Dish
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class OneDishDataSource {
    suspend fun getOneDish(id: String): Dish? {
        val result =
            Firebase.database(DATABASE_URl)
                .getReference("/")
                .get()
                .await()

        return result.child(id).getValue(Dish::class.java)
    }
}
