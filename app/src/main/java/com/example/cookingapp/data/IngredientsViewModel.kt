package com.example.cookingapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class IngredientsViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Ingredients>>
    private val repository: IngredientsRepository
    init {
        val ingredientsDao = IngredientsDatabase.getDatabase(application).ingredientsDao()
        repository = IngredientsRepository(ingredientsDao)
        readAllData = repository.readAllData
    }

    fun addIngredient(ingredient: Ingredient) {
        viewModelScope.Launch(Dispatchers.IO) {this: CoroutineScope
            repository.addIngredient(ingredient)
        }
    }
}