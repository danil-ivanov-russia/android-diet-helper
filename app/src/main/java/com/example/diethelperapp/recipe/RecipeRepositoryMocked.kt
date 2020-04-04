package com.example.diethelperapp.recipe

import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.db2.models.DishesModel

class RecipeRepositoryMocked: RecipeRepository {
    override suspend fun loadRecipe(recipeId: Int): DishesModel {
        return DietDAO.Dishes(

        )
    }
}