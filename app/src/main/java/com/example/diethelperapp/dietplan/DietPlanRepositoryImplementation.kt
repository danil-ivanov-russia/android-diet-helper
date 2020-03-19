package com.example.diethelperapp.dietplan

import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.db2.models.ListIngredientsModel
import com.example.diethelperapp.recipe.RecipeRepository

class DietPlanRepositoryImplementation(private val dao: DietDAO) : DietPlanRepository {
    override suspend fun loadDietPlan(dietId: String): List<DietPlanRepository.DietPlanDay> {
        var listDietPlanDay = mutableListOf<DietPlanRepository.DietPlanDay>()
        val tmpObj = dao.getCalendar()
        var  k = 0
        for(i in tmpObj.listIterator())
        {
           for (j in i.Dishes.listIterator())
           {
               when(j.mark[0])
               {
                   "Завтрак" -> listDietPlanDay[k].breakfastList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Обед" -> listDietPlanDay[k].lunchList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Ужин" -> listDietPlanDay[k].dinnerList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
                   "Перекус" -> listDietPlanDay[k].otherList.add(
                       RecipeRepository.Recipe(j.dishesName,getListIngredient(),j.calories,j.protein,j.fat,j.carbohydrates)

                   )
               }
           }
            k++
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
}

fun changeDishesMark(tmpObj: DietDAO.Dishes, mark: String): DietDAO.Dishes {

    val a = tmpObj.mark.indexOf(mark)
    val b = tmpObj.mark[0]
    tmpObj.mark[a] = b.also { tmpObj.mark[0] = mark }
    return tmpObj
}
fun getListIngredient(): List<RecipeRepository.Ingredient> =
   listOf(RecipeRepository.Ingredient("test",12.2,"test"))