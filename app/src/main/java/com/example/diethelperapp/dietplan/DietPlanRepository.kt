package com.example.diethelperapp.dietplan

import com.example.diethelperapp.recipe.RecipeRepository

interface DietPlanRepository {

    suspend fun loadDietPlan(dietId: String): List<DietPlanDay>?

    suspend fun addDishes(dishesName: String, day: String, mark: String)




    class DietPlanDay(
        val breakfastList: MutableList<RecipeRepository.Recipe>,
        val lunchList: MutableList<RecipeRepository.Recipe>,
        val dinnerList: MutableList<RecipeRepository.Recipe>,
        val otherList: MutableList<RecipeRepository.Recipe>
    )
}

