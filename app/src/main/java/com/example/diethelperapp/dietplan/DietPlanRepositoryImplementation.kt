package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.JsonUtil
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.common.models.DishesModel
import com.example.diethelperapp.db2.relationDataClasses.CalendarWithDishes

class DietPlanRepositoryImplementation(private val dao: DietDAO) : DietPlanRepository {

    lateinit var calendar: List<CalendarWithDishes>
    override suspend fun loadDietPlan(): List<DietPlanRepository.DietPlanDay> {
        val listDietPlanDay = mutableListOf<DietPlanRepository.DietPlanDay>()
        for (i in calendar) {
            val currentBreakfastList = mutableListOf<DishesModel>()
            val currentLunchList = mutableListOf<DishesModel>()
            val currentDinnerList = mutableListOf<DishesModel>()
            val currentOtherList = mutableListOf<DishesModel>()

            for (j in i.Calendar.dishesInBreakfast) {
                val tmpDishes = i.Dishes.filter { it.dishesId == j.trim().toInt() }[0]
                currentBreakfastList.add(
                    DietDAO.Dishes(
                        tmpDishes.dishesId,
                        tmpDishes.dishesName,
                        tmpDishes.calories,
                        tmpDishes.protein,
                        tmpDishes.fat,
                        tmpDishes.carbohydrates
                    )
                )
            }
            for (j in i.Calendar.dishesInDinner) {
                val tmpDishes = i.Dishes.filter { it.dishesId == j.trim().toInt() }[0]
                currentDinnerList.add(
                    DietDAO.Dishes(
                        tmpDishes.dishesId,
                        tmpDishes.dishesName,
                        tmpDishes.calories,
                        tmpDishes.protein,
                        tmpDishes.fat,
                        tmpDishes.carbohydrates
                    )
                )
            }
            for (j in i.Calendar.dishesInLunch) {
                val tmpDishes = i.Dishes.filter { it.dishesId == j.trim().toInt() }[0]
                currentLunchList.add(
                    DietDAO.Dishes(
                        tmpDishes.dishesId,
                        tmpDishes.dishesName,
                        tmpDishes.calories,
                        tmpDishes.protein,
                        tmpDishes.fat,
                        tmpDishes.carbohydrates
                    )
                )
            }
            for (j in i.Calendar.dishesInSnack) {
                val tmpDishes = i.Dishes.filter { it.dishesId == j.trim().toInt() }[0]
                currentOtherList.add(
                    DietDAO.Dishes(
                        tmpDishes.dishesId,
                        tmpDishes.dishesName,
                        tmpDishes.calories,
                        tmpDishes.protein,
                        tmpDishes.fat,
                        tmpDishes.carbohydrates
                    )
                )
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
    override suspend fun addDishes(dishesId: Int, foodLabel: Int, dayLabel: Int) {

        val tmpDay = calendar[foodLabel].Calendar
        when (dayLabel) {
            0 -> tmpDay.dishesInBreakfast.add(dishesId.toString())
            1 -> tmpDay.dishesInLunch.add(dishesId.toString())
            2 -> tmpDay.dishesInDinner.add(dishesId.toString())
            3 -> tmpDay.dishesInSnack.add(dishesId.toString())
        }
        dao.updateCalendar(tmpDay)
    }

    override suspend fun fillCalendar(dietId: Int, ctx: Context) {
        val currentDiet = dao.getCurrentDiet()
        if (dietId != currentDiet ) {
            dao.deleteCalendar()
            dao.insertUserCurrentDiet(DietDAO.User(dietId))
            val dietName = dao.getNameCertainDiet(dietId)
            var jsonUtil = JsonUtil(ctx, dietName)
            jsonUtil.setCalendarAndCrossRefCalendarWithDishes()
            dao.insertCalendar(jsonUtil.listCalendar)
            dao.insertCrossRefCalendarWithDishes(jsonUtil.listCrossRefCalendarOwnDishes)
        }

    }

    override suspend fun deleteDishesFromDay(
        dishesId: Int, foodLabel: Int, dayLabel: Int
    ) {

        val tmpDay = calendar[foodLabel].Calendar
        when (dayLabel) {
            0 -> tmpDay.dishesInBreakfast.remove(dishesId.toString())
            1 -> tmpDay.dishesInLunch.remove(dishesId.toString())
            2 -> tmpDay.dishesInDinner.remove(dishesId.toString())
            3 -> tmpDay.dishesInSnack.remove(dishesId.toString())
        }
        dao.updateCalendar(tmpDay)

    }

    override suspend fun setCalendar() {
        calendar = dao.getCalendar()
    }
}
