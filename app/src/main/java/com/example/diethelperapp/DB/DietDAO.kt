package com.example.diethelperapp.DB

import androidx.room.*


@Dao
abstract class DietDAO {

    @Query("SELECT diet_table.diet_name FROM diet_table")
    abstract suspend fun getAllDiet(): List<Diet?>

    @Insert
    abstract suspend fun insert(diet: Diet?)

    @Entity(tableName = "diet_table")
    class Diet {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
        var diet_name: String? = null

    }
}