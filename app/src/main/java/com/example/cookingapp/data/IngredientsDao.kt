package com.example.cookingapp.data

import androidx.room.Dao

@Dao
interface IngredientsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIngredient(ingredient: Ingredient)

    @Query(value: "SELECT * FROM ingredients_table ORDER BY ingID ASC")
    fun readAllData(): LiveData<List<Ingredient>>
}