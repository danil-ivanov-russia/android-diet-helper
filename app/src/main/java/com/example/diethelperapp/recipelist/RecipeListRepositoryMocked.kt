package com.example.diethelperapp.recipelist

import com.example.diethelperapp.common.models.DishesModel
import com.example.diethelperapp.db2.DietDAO

class RecipeListRepositoryMocked: RecipeListRepository {
    override suspend fun loadStandartRecipes(): List<DishesModel> {
        return listOf(
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 1",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 2",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 3",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            )
        )
    }

    override suspend fun loadUserRecipes(): List<DishesModel> {
        return listOf(
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 4",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 5",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String> ,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 6",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 9",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 10",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            )
        )
    }

    override suspend fun loadRecipesFromWeb(): List<DishesModel> {
        return listOf(
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 6",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 7",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            ),
            DietDAO.Dishes(
                0,
                "Тестовое блюдо 8",
                12.0,
                34.0,
                56.0,
                78.0,
                "test",
               listOf("123") as MutableList<String>,
                "lorem ipsum dolor sit"
            )
        )
    }

    override suspend fun deleteUserRecipe(dish: DishesModel) {
        TODO("Not yet implemented")
    }
}