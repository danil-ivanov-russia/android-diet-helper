package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.JsonUtil
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.common.models.DishesModel

class DietPlanRepositoryImplementation(private val dao: DietDAO) : DietPlanRepository {
    override suspend fun loadDietPlan(): List<DietPlanRepository.DietPlanDay> {
        val listDietPlanDay = mutableListOf<DietPlanRepository.DietPlanDay>()
        val tmpObj = dao.getCalendar()

        for (i in tmpObj) {
            val currentBreakfastList = mutableListOf<DishesModel>()
            val currentLunchList = mutableListOf<DishesModel>()
            val currentDinnerList = mutableListOf<DishesModel>()
            val currentOtherList = mutableListOf<DishesModel>()

            for (j in i.Dishes) {
                when (j.mark[0]) {
                    "Завтрак" -> currentBreakfastList.add(
                        DietDAO.Dishes(
                            j.dishesId,
                            j.dishesName,
                            j.calories,
                            j.protein,
                            j.fat,
                            j.carbohydrates
                        )

                    )
                    "Обед" -> currentLunchList.add(
                        DietDAO.Dishes(
                            j.dishesId,
                            j.dishesName,
                            j.calories,
                            j.protein,
                            j.fat,
                            j.carbohydrates
                        )
                    )
                    "Ужин" -> currentDinnerList.add(
                        DietDAO.Dishes(
                            j.dishesId,
                            j.dishesName,
                            j.calories,
                            j.protein,
                            j.fat,
                            j.carbohydrates
                        )
                    )
                    "Перекус" -> currentOtherList.add(
                        DietDAO.Dishes(
                            j.dishesId,
                            j.dishesName,
                            j.calories,
                            j.protein,
                            j.fat,
                            j.carbohydrates
                        )
                    )
                }
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



        // val i =  dao.getCurrentDiet()
//        if(!checkCurrentDiet(dietId, dao.getCurrentDiet()))
//        {
//            return
//        }
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
