package com.example.diethelperapp.common.models



interface ModelCalendar {
    val markDay: String
    val dishesInBreakfast: MutableList<String>
    val dishesInLunch: MutableList<String>
    val dishesInDinner: MutableList<String>
    val dishesInSnack: MutableList<String>
}