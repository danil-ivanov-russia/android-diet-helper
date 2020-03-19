package com.example.diethelperapp.dietplan

import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.db2.models.ListIngredientsModel

class DietPlanRepositoryImplementation(private val dao: DietDAO): DietPlanRepository {
    override suspend fun loadDietPlan(dietId: String): List<DietPlanRepository.DietPlanDay> {
        TODO("Not yet implemented")
    }

    override suspend fun addDishes(
        dishesName: String,
        day: String,
        mark: String
    ) {
        dao.insertCrossRefCalendarWithDishes(DietDAO.CrossRefCalendarOwnDishes(dao.getMarkDietByDay(day),dao.getDishesIdByName(dishesName)))
        val tmpObjDishes =  changeDishesMark(dao.getDishes(dishesName),mark)
        dao.updateDishes(tmpObjDishes)

    }
}
fun changeDishesMark(tmpObj: DietDAO.Dishes, mark: String): DietDAO.Dishes
{

    val a = tmpObj.mark.indexOf(mark)
    val b = tmpObj.mark[0]
    tmpObj.mark[a] = b.also { tmpObj.mark[0] = mark}
    return tmpObj
}