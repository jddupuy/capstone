package com.example.cookingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients_table")
class Ingredients {
    @PrimaryKey(autoGenerate = true)
    val ingID: Int,
    val ingName: String,
    val ingQuantity: Int
}