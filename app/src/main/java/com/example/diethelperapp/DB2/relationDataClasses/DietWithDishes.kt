package com.example.diethelperapp.db2.relationDataClasses

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diethelperapp.db2.DietDAO

data class DietWithDishes(
    @Embedded val Diet: DietDAO.Diet,
    @Relation(
        parentColumn = "dietId",
        entityColumn = "dishesId",
        associateBy = Junction(DietDAO.CrossRefDietOwnDishes::class)
    )
    val Dishes: List<DietDAO.Dishes>
)