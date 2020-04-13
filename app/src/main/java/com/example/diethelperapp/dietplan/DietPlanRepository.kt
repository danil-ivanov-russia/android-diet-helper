package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.models.DishesModel
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.db2.relationDataClasses.CalendarWithDishes

interface DietPlanRepository {

    suspend fun loadDietPlan(): List<DietPlanDay>?

    suspend fun addDishes(dishesId:Int, foodLabel: Int, dayLabel:Int)

    suspend fun fillCalendar(dietId: Int, ctx: Context)

    suspend fun deleteDishesFromDay(dishesId:Int,foodLabel: Int, dayLabel:Int)

    suspend fun setCalendar()


    class DietPlanDay(
        val breakfastList: MutableList<DishesModel>,
        val lunchList: MutableList<DishesModel>,
        val dinnerList: MutableList<DishesModel>,
        val otherList: MutableList<DishesModel>
    )
}

