package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.models.DishesModel

interface DietPlanRepository {

    suspend fun loadDietPlan(): List<DietPlanDay>?

   // suspend fun addDishes(dishesName: String, day: String, mark: String)

    suspend fun fillCalendar(dietId: Int, ctx: Context)


    class DietPlanDay(
        val breakfastList: MutableList<DishesModel>,
        val lunchList: MutableList<DishesModel>,
        val dinnerList: MutableList<DishesModel>,
        val otherList: MutableList<DishesModel>
    )
}

