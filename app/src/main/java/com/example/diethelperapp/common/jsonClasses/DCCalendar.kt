package com.example.diethelperapp.common.jsonClasses


data class DCCalendar
    (
    val arrayCalendar: Array<tmpCalendar>
)

data class tmpCalendar(
    val markDay: String,
    val arrayDishes: Array<Int>,
    val dishesInBreakfast: MutableList<String>,
    val dishesInLunch: MutableList<String>,
    val dishesInDinner: MutableList<String>,
    val dishesInSnack: MutableList<String>


)
