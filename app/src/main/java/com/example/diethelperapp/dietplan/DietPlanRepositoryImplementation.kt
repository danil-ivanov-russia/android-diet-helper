package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.JsonUtil
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.common.models.DishesModel
/*  DietDAO.Dishes(
                            j.dishesId,
                            j.dishesName,
                            j.calories,
                            j.protein,
                            j.fat,
                            j.carbohydrates
                        )*/
class DietPlanRepositoryImplementation(private val dao: DietDAO) : DietPlanRepository {
    override suspend fun loadDietPlan(): List<DietPlanRepository.DietPlanDay> {
        val listDietPlanDay = mutableListOf<DietPlanRepository.DietPlanDay>()
        val tmpObj = dao.getCalendar()

        for (i in tmpObj) {
            val currentBreakfastList = mutableListOf<DishesModel>()
            val currentLunchList = mutableListOf<DishesModel>()
            val currentDinnerList = mutableListOf<DishesModel>()
            val currentOtherList = mutableListOf<DishesModel>()

            for(j in i.Calendar.dishesInBreakfast)
            {
                val tmpDishes = i.Dishes.filter { it.dishesId==j.trim().toInt() }[0]
                currentBreakfastList.add(DietDAO.Dishes(
                    tmpDishes.dishesId,
                    tmpDishes.dishesName,
                    tmpDishes.calories,
                    tmpDishes.protein,
                    tmpDishes.fat,
                    tmpDishes.carbohydrates
                ))
            }
            for(j in i.Calendar.dishesInDinner)
            {
                val tmpDishes = i.Dishes.filter { it.dishesId==j.trim().toInt() }[0]
                currentDinnerList.add(DietDAO.Dishes(
                    tmpDishes.dishesId,
                    tmpDishes.dishesName,
                    tmpDishes.calories,
                    tmpDishes.protein,
                    tmpDishes.fat,
                    tmpDishes.carbohydrates
                ))
            }
            for(j in i.Calendar.dishesInLunch)
            {
                val tmpDishes = i.Dishes.filter { it.dishesId==j.trim().toInt() }[0]
                currentLunchList.add(DietDAO.Dishes(
                    tmpDishes.dishesId,
                    tmpDishes.dishesName,
                    tmpDishes.calories,
                    tmpDishes.protein,
                    tmpDishes.fat,
                    tmpDishes.carbohydrates
                ))
            }
            for(j in i.Calendar.dishesInSnack)
            {
                val tmpDishes = i.Dishes.filter { it.dishesId==j.trim().toInt() }[0]
                currentOtherList.add(DietDAO.Dishes(
                    tmpDishes.dishesId,
                    tmpDishes.dishesName,
                    tmpDishes.calories,
                    tmpDishes.protein,
                    tmpDishes.fat,
                    tmpDishes.carbohydrates
                ))
            }
            listDietPlanDay.add(
                DietPlanRepository.DietPlanDay(
                    currentBreakfastList,
                    currentLunchList,
                    currentDinnerList,
                    currentOtherList
                )
            )
        }
        return listDietPlanDay
    }

    /* Как это будет работать. На вход подается объект блюда, метка приема пищи и метка дня.
    Сперва добавляю id блюда и метку дня в таблицу crossRefCalendarOwnDishes
    После я проверяю, есть ли метка приема пищи у данного блюда
    Если она есть, то на этом работа функции закончена
    Если ее нет, то я в начало массива меток в блюде добавляю нужную метку, обновляю блюдо и только потом завершаю работу.

        */
    override suspend fun addDishes(dishes: DietDAO.Dishes, foodLabel: String, dayLabel: String) {

        dao.insertCrossRefCalendarWithDishes(
            DietDAO.CrossRefCalendarOwnDishes(
                dayLabel,
                dishes.dishesId
            )
        )
        if(!dishes.mark.contains(foodLabel))
        {
            dishes.mark.add(0,foodLabel)
        }
        dao.updateDishes(dishes)
    }

    override suspend fun fillCalendar(dietId: Int, ctx: Context) {


        dao.deleteCalendar()
        dao.insertUserCurrentDiet(DietDAO.User(dietId))
        val dietName = dao.getNameCertainDiet(dietId)
        var jsonUtil = JsonUtil(ctx, dietName)
        jsonUtil.setCalendarAndCrossRefCalendarWithDishes()
        dao.insertCalendar(jsonUtil.listCalendar)
        dao.insertCrossRefCalendarWithDishes(jsonUtil.listCrossRefCalendarOwnDishes)
        val tmpObj = dao.getCalendar()
    }

    override suspend fun deleteDishesFromDay(
        dishes: DietDAO.Dishes,
        dayLabel: String
    ) {
        dao.deleteDishesFromDay(DietDAO.CrossRefCalendarOwnDishes(dayLabel,dishes.dishesId))
    }
}

fun changeDishesMark(tmpObj: DietDAO.Dishes, mark: String): DietDAO.Dishes {


    val a = tmpObj.mark.indexOf(mark)
    val b = tmpObj.mark[0]
    tmpObj.mark[a] = b.also { tmpObj.mark[0] = mark }
    return tmpObj
}


fun checkCurrentDiet(dietId: Int, currentDietId: Int): Boolean = dietId != currentDietId
