package com.example.diethelperapp.common.jsonClasses


data class DCCalendar
    (
    val arrayCalendar: Array<tmpCalendar>
)
data class tmpCalendar(
    val markDay: String,
    val arrayDishes: Array<Int>


)
