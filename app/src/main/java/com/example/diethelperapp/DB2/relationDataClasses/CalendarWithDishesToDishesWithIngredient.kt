package com.example.diethelperapp.db2.relationDataClasses

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diethelperapp.db2.DietDAO

data class CalendarWithDishesToDishesWithIngredient(
    @Embedded
    val CalendarWithDishes:CalendarWithDishes,
    @Relation(
        entity = DietDAO.Dishes::class,
        parentColumn = "dishesId",
        entityColumn = "dishesId"
        // associateBy = Junction(DietDAO.CrossRefCalendarOwnDishes::class)
    )
    val DishesWithIngredients: List<DietWithDishes>
)