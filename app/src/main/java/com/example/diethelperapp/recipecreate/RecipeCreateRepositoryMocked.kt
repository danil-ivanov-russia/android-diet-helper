package com.example.diethelperapp.recipecreate

import com.example.diethelperapp.db2.DietDAO

class RecipeCreateRepositoryMocked : RecipeCreateRepository {
    override suspend fun addRecipeToDatabase(): DietDAO.Dishes {
        TODO("Not yet implemented")
    }

    override suspend fun loadIngredients(): List<DietDAO.Ingredients> {
        return listOf(
            DietDAO.Ingredients(
                1,
                "ingredient 1",
                2.3,
                4.5,
                6.7,
                8.9
            ),
            DietDAO.Ingredients(
                1,
                "ingredient 2",
                2.3,
                4.5,
                6.7,
                8.9
            ),
            DietDAO.Ingredients(
                1,
                "ingredient 3",
                2.3,
                4.5,
                6.7,
                8.9
            ),
            DietDAO.Ingredients(
                1,
                "ingredient 4",
                2.3,
                4.5,
                6.7,
                8.9
            ),
            DietDAO.Ingredients(
                1,
                "ingredient 5",
                2.3,
                4.5,
                6.7,
                8.9
            )
        )
    }

    override suspend fun getIngredientById(id: Int): DietDAO.Ingredients {
        return DietDAO.Ingredients(
            1,
            "ingredient 1",
            2.3,
            4.5,
            6.7,
            8.9
        )
    }
}