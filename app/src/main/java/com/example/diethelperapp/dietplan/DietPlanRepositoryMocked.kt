package com.example.diethelperapp.dietplan

import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.recipe.RecipeRepository

class DietPlanRepositoryMocked(): DietPlanRepository {
    override suspend fun loadDietPlan(dietId: String): List<DietPlanRepository.DietPlanDay> {
        return listOf(
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Test",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Test",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Test",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Test",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(

                )
            ),
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Test",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                )
            ),
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(

                )
            ),
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "Яичница с беконом",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(

                )
            ),
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(

                )
            ),
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(

                )
            ),
            DietPlanRepository.DietPlanDay(
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    ),
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(
                    RecipeRepository.Recipe(
                        recipeId = "0",
                        ingredients = listOf(
                            RecipeRepository.Ingredient(
                                "Яйцо",
                                2.0,
                                "штуки"),
                            RecipeRepository.Ingredient(
                                "Бекон",
                                100.0,
                                "г")
                        ),
                        calories = 438.0,
                        protein = 26.7,
                        fat = 35.6,
                        carbohydrate = 0.8
                    )
                ),
                listOf(

                )
            )
        )

    }

    override suspend fun addDishes(dishesName: String, day: String, mark: String) {
        TODO("Not yet implemented")
    }


}

