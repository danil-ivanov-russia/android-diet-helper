package com.example.diethelperapp.diet

import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.recipe.RecipeRepository
import com.example.diethelperapp.recipe.RecipeRepositoryMocked
import kotlinx.coroutines.delay

class DietRepositoryMocked: DietRepository {
//    override suspend fun getDiets(): List<DietRepository.Diet> {
//        return listOf(loadDiet("test"))
//
//    }
//
//    override suspend fun getDietsNames(): List<String> {
//        delay(1500L)
//        return listOf(
//            "Гречневая диета",
//            "Низкоуглеводная диета",
//            "Болгарская диета")
//    }
//
//    override suspend fun loadDiet(dietId: String): DietRepository.Diet {
//        delay(1500L)
//        return DietRepository.Diet(
//            dietId = "0",
//            name = "Гречневая диета",
//            description = "Есть можно только гречку, лучше диеты ещё не придумали.",
//            recommendations = listOf("Гречка - хорошо.", "Остальное - плохо"),
//            duration = "1 неделя",
//            recipes = listOf(RecipeRepository.Recipe(
//                recipeId = "Яичница без гречки",
//                ingredients = listOf(
//                    RecipeRepository.Ingredient(
//                        "Яйцо",
//                        2.0,
//                        "штуки"),
//                    RecipeRepository.Ingredient(
//                        "Бекон",
//                        100.0,
//                        "г")
//                ),
//                calories = 438.0,
//                protein = 26.7,
//                fat = 35.6,
//                carbohydrate = 0.8
//                )
//            )
//        )
//    }

    override suspend fun getAllDiet(): List<DietModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getIdCertainDiet(name_certain_diet: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getNameCertainDiet(id_certain_diet: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getAllNameDiets(): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDescriptionCertainDiet(id_certain_diet: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDurationCertainDiet(id_certain_diet: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//
    override suspend fun getCertainDietById(id_certain_diet: Int): DietModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}