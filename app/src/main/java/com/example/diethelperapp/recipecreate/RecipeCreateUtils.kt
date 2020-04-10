package com.example.diethelperapp.recipecreate

import androidx.databinding.InverseMethod
import java.text.DecimalFormat

object RecipeCreateUtils {
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double): String = DecimalFormat("0.##").format(value)

    @JvmStatic
    fun stringToDouble(value: String): Double = try {
        value.toDouble()
    } catch (t: Throwable) {
        100.0
    }
}