package com.example.recepies.ui.pdp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recepies.model.Dish
import com.example.recepies.remote.DishesDataSource
import com.example.recepies.remote.OneDishDataSource
import kotlinx.coroutines.launch

class PdpViewModel : ViewModel() {

    private val oneDishDataSource = OneDishDataSource()
    private val oneDishData = mutableStateOf<Dish?>(null)
    fun oneDishData() = oneDishData.value

    fun loadOneDish(id: String) {
        viewModelScope.launch {
            oneDishData.value = oneDishDataSource.getOneDish(id)
        }
    }
}