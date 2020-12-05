package com.example.cookingapp.data

import androidx.room.Database

@Database(entities = [Ingredients::class], version = 1, exportSchema = false)
class IngredientsDatabase: RoomDatabase() {

    abstract fun IngredientsDao(): IngredientsDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): IngredientsDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(lock: this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        IngredientsDatabase::class.java,
                        name: "ingredients_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}