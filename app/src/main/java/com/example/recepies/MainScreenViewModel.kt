package com.example.recepies

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recepies.model.Dish
import com.example.recepies.remote.DishesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    private val dishesDataSource = DishesDataSource()
    private val _dishesData = MutableStateFlow<List<Dish>>(listOf())
//    val dishesData = _dishesData.asStateFlow()
    fun dishesData() = _dishesData.value

    fun initializeViewModel(context: Context) {
        dataLoad(context = context)
    }

    private fun dataLoad(context: Context) {
        viewModelScope.launch {
            _dishesData.update { dishesDataSource.getProducts() }
        }
    }

}