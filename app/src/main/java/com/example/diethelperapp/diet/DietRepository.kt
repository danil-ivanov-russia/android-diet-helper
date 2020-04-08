package com.example.diethelperapp.diet

import com.example.diethelperapp.common.models.DietModel

interface DietRepository {

    suspend fun getAllDiet(): List<DietModel>

    suspend fun getIdCertainDiet(name_certain_diet:String): Int

    suspend fun getNameCertainDiet(id_certain_diet:Int): String

    suspend fun getAllNameDiets(): List<String>

    suspend fun getDescriptionCertainDiet(id_certain_diet:Int): String

    suspend fun getDurationCertainDiet(id_certain_diet:Int): Int

    suspend fun getCertainDietById(id_certain_diet:Int): DietModel


}