package com.example.diethelperapp.recipe

import kotlinx.coroutines.delay

class RecipeRepositoryMocked: RecipeRepository {
    override suspend fun loadRecipe(recipeId: String): RecipeRepository.Recipe {
        delay(1000L)
        return RecipeRepository.Recipe(
            recipeId = recipeId,
            ingredients = listOf(
                RecipeRepository.Ingredient(
                    "Яйцо",
                    2.0,
                    "штуки"),
                RecipeRepository.Ingredient(
                    "Бекон",
                    100.0,
                    "г")
            ),
            calories = 438.0,
            protein = 26.7,
            fat = 35.6,
            carbohydrate = 0.8
        )
    }
}