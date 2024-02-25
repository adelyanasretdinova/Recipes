package com.example.recepies.ui.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recepies.model.Dish
import com.example.recepies.remote.DishesDataSource
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    private val dishesDataSource = DishesDataSource()
    private val dishesData = mutableStateOf<List<Dish>>(listOf())
    fun dishesData() = dishesData.value
    init {
        dataLoad()
    }

    private fun dataLoad() {
        viewModelScope.launch {
            dishesData.value = dishesDataSource.getListOfAllDishes()
        }
    }
}
