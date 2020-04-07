package com.example.diethelperapp.dietplan

import android.content.Context
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.recipe.RecipeRepository

class DietPlanRepositoryMocked(): DietPlanRepository {
    override suspend fun loadDietPlan(): List<DietPlanRepository.DietPlanDay>? {
       // return MutableList( DietPlanRepository.DietPlanDay())
//        return listOf(
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Test",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Test",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Test",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Test",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//
//                )
//            ),
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Test",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>
//            ),
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//
//                ) as MutableList<RecipeRepository.Recipe>
//            ),
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "Яичница с беконом",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//
//                ) as MutableList<RecipeRepository.Recipe>
//            ),
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//
//                ) as MutableList<RecipeRepository.Recipe>
//            ),
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ) as MutableList<RecipeRepository.Recipe>,
//                listOf(
//
//                )
//            ),
//            DietPlanRepository.DietPlanDay(
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ),
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    ),
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ),
//                listOf(
//                    RecipeRepository.Recipe(
//                        recipeId = "0",
//                        ingredients = listOf(
//                            RecipeRepository.Ingredient(
//                                "Яйцо",
//                                2.0,
//                                "штуки"),
//                            RecipeRepository.Ingredient(
//                                "Бекон",
//                                100.0,
//                                "г")
//                        ),
//                        calories = 438.0,
//                        protein = 26.7,
//                        fat = 35.6,
//                        carbohydrate = 0.8
//                    )
//                ),
//                listOf(
//
//                )
//            )
//        )
return null
    }

//    override suspend fun addDishes(dishesName: String, day: String, mark: String) {
//        TODO("Not yet implemented")
//    }

    override suspend fun fillCalendar(dietId: Int, ctx: Context) {
        TODO("Not yet implemented")
    }


}

