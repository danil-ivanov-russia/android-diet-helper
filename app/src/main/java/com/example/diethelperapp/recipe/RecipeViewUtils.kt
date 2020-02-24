package com.example.diethelperapp.recipe

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
        if (double % 1.0 == 0.0){
            return "%.0f".format(double)
        }
        else return double.toString()
    }
}