package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.models.DishesModel
import com.example.diethelperapp.db2.DietDAO

interface DietPlanRepository {

    suspend fun loadDietPlan(): List<DietPlanDay>?

    suspend fun addDishes(dishes: DietDAO.Dishes, foodLabel: String, dayLabel:String)

    suspend fun fillCalendar(dietId: Int, ctx: Context)

    suspend fun deleteDishesFromDay(dishes: DietDAO.Dishes,  dayLabel: String)


    class DietPlanDay(
        val breakfastList: MutableList<DishesModel>,
        val lunchList: MutableList<DishesModel>,
        val dinnerList: MutableList<DishesModel>,
        val otherList: MutableList<DishesModel>
    )
}

