package com.example.diethelperapp.common.jsonClasses


data class DCDiet(
    val arrayDiet: Array<tmpDiet>
)

data class tmpDiet (
    val dietId: Int,
    val dietName: String,
    val supportingInformation: String,
    val duration: Int,
    val arrayDishesBelongDiet: Array<Int>
)