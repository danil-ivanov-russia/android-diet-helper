package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.recipe.RecipeRepository

interface DietPlanRepository {

    suspend fun loadDietPlan(): List<DietPlanDay>?

    suspend fun addDishes(dishesName: String, day: String, mark: String)

    suspend fun fillCalendar(dietId: Int, ctx: Context)


    class DietPlanDay(
        val breakfastList: MutableList<RecipeRepository.Recipe>,
        val lunchList: MutableList<RecipeRepository.Recipe>,
        val dinnerList: MutableList<RecipeRepository.Recipe>,
        val otherList: MutableList<RecipeRepository.Recipe>
    )
}

