package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.JsonUtil
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.common.models.DishesModel

class DietPlanRepositoryImplementation(private val dao: DietDAO) : DietPlanRepository {
    override suspend fun loadDietPlan(): List<DietPlanRepository.DietPlanDay> {
        val listDietPlanDay = mutableListOf<DietPlanRepository.DietPlanDay>()
//        val tmpObj1 = dao.getCalendar()
//        dao.deleteCalendar()
        val tmpObj = dao.getCalendar()

        for(i in tmpObj)
        {
            val currentBreakfastList = mutableListOf<DishesModel>()
            val currentLunchList = mutableListOf<DishesModel>()
            val currentDinnerList = mutableListOf<DishesModel>()
            val currentOtherList = mutableListOf<DishesModel>()

           for (j in i.Dishes)
           {
               when(j.mark[0])
               {
                   "Завтрак" -> currentBreakfastList.add(
                       DietDAO.Dishes(j.dishesId,j.dishesName,j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Обед" -> currentLunchList.add(
                       DietDAO.Dishes(j.dishesId,j.dishesName,j.calories,j.protein,j.fat,j.carbohydrates)
                   )
                   "Ужин" -> currentDinnerList.add(
                       DietDAO.Dishes(j.dishesId,j.dishesName,j.calories,j.protein,j.fat,j.carbohydrates)
                   )
                   "Перекус" -> currentOtherList.add(
                       DietDAO.Dishes(j.dishesId,j.dishesName,j.calories,j.protein,j.fat,j.carbohydrates)
                   )
               }
           }
            listDietPlanDay.add(DietPlanRepository.DietPlanDay(currentBreakfastList, currentLunchList, currentDinnerList, currentOtherList))
        }
        return listDietPlanDay
    }

//    override suspend fun addDishes(
//        dishesName: String,
//        day: String,
//        mark: String
//    ) {
//        dao.insertCrossRefCalendarWithDishes(
//            DietDAO.CrossRefCalendarOwnDishes(
//                dao.getmarkDayByDay(
//                    day
//                ), dao.getDishesIdByName(dishesName)
//            )
//        )
//        val tmpObjDishes = changeDishesMark(dao.getDishes(dishesName), mark)
//        dao.updateDishes(tmpObjDishes)
//
//    }

    override suspend fun fillCalendar(dietId: Int, ctx: Context) {

       // val i =  dao.getCurrentDiet()
//        if(!checkCurrentDiet(dietId, dao.getCurrentDiet()))
//        {
//            return
//        }
        dao.deleteCalendar()
        val tmpObj1 = dao.getCalendar()
        dao.insertUserCurrentDiet(DietDAO.User(dietId))
        val dietName = dao.getNameCertainDiet(dietId)
        var jsonUtil = JsonUtil(ctx, dietName)
        jsonUtil.setCalendarAndCrossRefCalendarWithDishes()
        dao.insertCalendar(jsonUtil.listCalendar)
        dao.insertCrossRefCalendarWithDishes(jsonUtil.listCrossRefCalendarOwnDishes)
        val tmpObj = dao.getCalendar()
    }
}

fun changeDishesMark(tmpObj: DietDAO.Dishes, mark: String): DietDAO.Dishes {


    val a = tmpObj.mark.indexOf(mark)
    val b = tmpObj.mark[0]
    tmpObj.mark[a] = b.also { tmpObj.mark[0] = mark }
    return tmpObj
}


fun checkCurrentDiet(dietId: Int, currentDietId: Int): Boolean = dietId != currentDietId
