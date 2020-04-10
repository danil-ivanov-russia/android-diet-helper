package com.example.diethelperapp.recipelist

import com.example.diethelperapp.common.models.DishesModel
import com.example.diethelperapp.db2.DietDAO

class RecipeListRepositoryImplementation(private val dao: DietDAO): RecipeListRepository {
    override suspend fun loadStandartRecipes(): List<DishesModel> {
        return dao.getAllBasicDishes()
    }

    override suspend fun loadUserRecipes(): List<DishesModel> {
        return dao.getAllCustomDishes()
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
}