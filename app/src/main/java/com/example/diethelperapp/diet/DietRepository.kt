package com.example.diethelperapp.diet

import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.recipe.RecipeRepository

interface DietRepository {

    suspend fun getAllDiet(): List<DietModel>

    suspend fun getIdCertainDiet(name_certain_diet:String): Int

    suspend fun getNameCertainDiet(id_certain_diet:Int): String

    suspend fun getAllNameDiets(): List<String>

    suspend fun getDescriptionCertainDiet(id_certain_diet:Int): String

    suspend fun getDurationCertainDiet(id_certain_diet:Int): Int

    suspend fun getCertainDietById(id_certain_diet:Int): DietModel

// Модель DietModel заменяет этот класс
    class Diet(
        var id_diet: Int = 0,
        var diet_name: String? = null,
        var supporting_information: String? = null,
        var duration: Int = 0
    )

}