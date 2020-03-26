package com.example.diethelperapp.recipecreate

import com.example.diethelperapp.db2.DietDAO

interface RecipeCreateRepository {

    suspend fun addRecipeToDatabase(): DietDAO.Dishes

    suspend fun loadIngredients(): List<DietDAO.Ingredients>

    suspend fun getIngredientById(id: Int): DietDAO.Ingredients
}