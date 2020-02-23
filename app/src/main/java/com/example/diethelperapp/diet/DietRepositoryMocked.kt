package com.example.diethelperapp.diet

import com.example.diethelperapp.recipe.RecipeRepository
import com.example.diethelperapp.recipe.RecipeRepositoryMocked
import kotlinx.coroutines.delay

class DietRepositoryMocked: DietRepository {
    override suspend fun getDiets(): List<DietRepository.Diet> {
        return listOf(loadDiet("test"))

    }

    override suspend fun getDietsNames(): List<String> {
        delay(1500L)
        return listOf(
            "123",
            "456",
            "789")
    }

    override suspend fun loadDiet(dietId: String): DietRepository.Diet {
        delay(1500L)
        return DietRepository.Diet(
            dietId = "0",
            name = "Гречневая",
            description = "Есть можно только гречку, лучше диеты ещё не придумали.",
            recommendations = listOf("Гречка - хорошо.", "Остальное - плохо"),
            duration = "1 неделя",
            recipes = listOf(RecipeRepository.Recipe(
                recipeId = "Яичница без гречки",
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
            )
        )
    }


}