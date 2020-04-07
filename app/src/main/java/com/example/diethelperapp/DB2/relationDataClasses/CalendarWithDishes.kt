package com.example.diethelperapp.db2.relationDataClasses


import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diethelperapp.db2.DietDAO

data class CalendarWithDishes(
    @Embedded val Calendar: DietDAO.Calendar,
    @Relation(
        parentColumn = "markDay",
        entityColumn = "dishesId",
        associateBy = Junction(DietDAO.CrossRefCalendarOwnDishes::class)
    )
    val Dishes: List<DietDAO.Dishes>



)