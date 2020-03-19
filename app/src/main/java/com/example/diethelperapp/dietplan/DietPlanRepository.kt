package com.example.diethelperapp.dietplan

import com.example.diethelperapp.recipe.RecipeRepository

interface DietPlanRepository {

    suspend fun loadDietPlan(dietId: String): List<DietPlanDay>

    suspend fun addDishes(dishesName: String, day: String, mark: String)

    class DietPlanDay(
        val breakfastList: List<RecipeRepository.Recipe>,
        val lunchList: List<RecipeRepository.Recipe>,
        val dinnerList: List<RecipeRepository.Recipe>,
        val otherList: List<RecipeRepository.Recipe>
    )
}

