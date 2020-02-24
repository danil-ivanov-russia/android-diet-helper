package com.example.diethelperapp.diet

import com.example.diethelperapp.recipe.RecipeRepository

interface DietRepository {

    suspend fun getDiets(): List<Diet>

    suspend fun getDietsNames(): List<String>

    suspend fun loadDiet(dietId: String): Diet

    class Diet(
        val dietId: String,
        val name: String,
        val description: String,
        val recommendations: List<String>,
        val recipes: List<RecipeRepository.Recipe>,
        val duration: String
    )
}