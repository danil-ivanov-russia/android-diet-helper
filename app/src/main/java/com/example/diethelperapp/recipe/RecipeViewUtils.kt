package com.example.diethelperapp.recipe

import java.text.DecimalFormat

object RecipeViewUtils {
    @JvmStatic
    fun listOfIngredientsToString(list: List<RecipeRepository.Ingredient>?): String? {
        list ?: return null
        var resultString = ingredientToString(list.first())
        list.drop(1).forEach(){
            resultString = resultString
                .plus('\n')
                .plus(ingredientToString(it))
        }
        return resultString
    }

    fun ingredientToString(ingredient: RecipeRepository.Ingredient): String{
        return ingredient.name+", "+amountToString(ingredient.amount)+" "+ingredient.amountUnits

    }

    @JvmStatic
    fun amountToString(double: Double): String{
        val df = DecimalFormat("0.##")
        /*if (double % 1.0 == 0.0){
            return "%.0f".format(double)
        }
        else return "%.3f".format(double)
         */
        return df.format(double)
    }
}