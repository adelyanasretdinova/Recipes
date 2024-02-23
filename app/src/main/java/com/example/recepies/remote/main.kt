package com.example.recepies.remote

suspend fun main(){
    DishesDataSource().getProducts()
}