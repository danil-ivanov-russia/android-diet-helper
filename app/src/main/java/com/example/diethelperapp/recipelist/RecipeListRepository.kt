package com.example.diethelperapp.recipelist

import com.example.diethelperapp.common.models.DishesModel

interface RecipeListRepository {

    suspend fun loadStandartRecipes(): List<DishesModel>

    suspend fun loadUserRecipes(): List<DishesModel>

    suspend fun loadRecipesFromWeb(): List<DishesModel>

    suspend fun deleteUserRecipe(dish: DishesModel)
}