package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.common.JsonUtil
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.db2.models.ListIngredientsModel
import com.example.diethelperapp.recipe.RecipeRepository

class DietPlanRepositoryImplementation(private val dao: DietDAO) : DietPlanRepository {
    override suspend fun loadDietPlan(): List<DietPlanRepository.DietPlanDay> {
        val listDietPlanDay = mutableListOf<DietPlanRepository.DietPlanDay>()
//        val tmpObj1 = dao.getCalendar()
//        dao.deleteCalendar()
        val tmpObj = dao.getCalendar()

        for(i in tmpObj)
        {
            val currentBreakfastList = mutableListOf<RecipeRepository.Recipe>()
            val currentLunchList = mutableListOf<RecipeRepository.Recipe>()
            val currentDinnerList = mutableListOf<RecipeRepository.Recipe>()
            val currentOtherList = mutableListOf<RecipeRepository.Recipe>()

           for (j in i.Dishes)
           {
               when(j.mark[0])
               {
                   "Завтрак" -> currentBreakfastList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Обед" -> currentLunchList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Ужин" -> currentDinnerList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Перекус" -> currentOtherList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
               }
           }
            listDietPlanDay.add(DietPlanRepository.DietPlanDay(currentBreakfastList, currentLunchList, currentDinnerList, currentOtherList))
        }
        return listDietPlanDay
    }

    override suspend fun addDishes(
        dishesName: String,
        day: String,
        mark: String
    ) {
        dao.insertCrossRefCalendarWithDishes(
            DietDAO.CrossRefCalendarOwnDishes(
                dao.getMarkDietByDay(
                    day
                ), dao.getDishesIdByName(dishesName)
            )
        )
        val tmpObjDishes = changeDishesMark(dao.getDishes(dishesName), mark)
        dao.updateDishes(tmpObjDishes)

    }

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
        jsonUtil.setCalendar()
        dao.insertCalendar(jsonUtil.listCalendar)
        val tmpObj = dao.getCalendar()
    }
}

fun changeDishesMark(tmpObj: DietDAO.Dishes, mark: String): DietDAO.Dishes {


    val a = tmpObj.mark.indexOf(mark)
    val b = tmpObj.mark[0]
    tmpObj.mark[a] = b.also { tmpObj.mark[0] = mark }
    return tmpObj
}
fun getListIngredient(): List<RecipeRepository.Ingredient> =
   listOf(RecipeRepository.Ingredient("test",12.2,"test"))

fun checkCurrentDiet(dietId: Int, currentDietId: Int): Boolean = dietId != currentDietId
