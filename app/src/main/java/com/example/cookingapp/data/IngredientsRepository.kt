package com.example.cookingapp.data

class IngredientsRepository(private val ingredientsDao: IngredientsDao) {

    val readAllData: LiveData<List<Ingredients>> = ingredientsDao.readAllData()

    fun addIngredient(ingredient: Ingredient) {
        ingredientsDao.addIngredient(ingredient)
    }
}