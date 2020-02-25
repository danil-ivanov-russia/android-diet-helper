package com.example.diethelperapp.DB

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class DietWithDishes(
    @Embedded val Diet: DietDAO.Diet,
    @Relation(
        parentColumn = "id_own_diet",
        entityColumn = "id_link_dishes",
        associateBy = Junction(DietDAO.CrossRefDietOwnDishes::class)
    )
    val dogs: List<DietDAO.Diet>
)