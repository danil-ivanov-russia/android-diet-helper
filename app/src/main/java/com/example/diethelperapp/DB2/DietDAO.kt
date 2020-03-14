package com.example.diethelperapp.DB

import androidx.room.*
import com.example.diethelperapp.DB2.Models.CrossRefDietOwnDishesModel
import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.DB2.Models.DishesModel
import com.example.diethelperapp.DB2.Models.ListIngredientsModel

@Dao
abstract class DietDAO {
    @Query("SELECT * FROM Diet")
    abstract suspend fun getAllDiet(): List<Diet>

    @Query("SELECT dietId FROM Diet Where dietName = :name_certain_diet")
    abstract suspend fun getIdCertainDiet(name_certain_diet: String): Int

    @Query("SELECT dietName FROM Diet Where dietId = :id_certain_diet")
    abstract suspend fun getNameCertainDiet(id_certain_diet: Int): String

    @Query("SELECT dietName FROM Diet")
    abstract suspend fun getAllNameDiets(): List<String>

    @Query("SELECT supportingInformation  FROM Diet Where dietName = :id_certain_diet")
    abstract suspend fun getDescriptionCertainDiet(id_certain_diet: Int): String

    @Query("SELECT duration  FROM Diet Where dietId = :id_certain_diet")
    abstract suspend fun getDurationCertainDiet(id_certain_diet: Int): Int

    @Query("SELECT * FROM Diet Where dietId = :id_certain_diet")
    abstract suspend fun getCertainDietById(id_certain_diet: Int): Diet

    @Query("SELECT COUNT(*) FROM Diet")
    abstract suspend fun getCountLines(): Int

     //очень не уверен что этот запрос работает
    @Transaction
    @Query("SELECT * FROM Diet Where dietId = :id")
    abstract suspend fun getDishesByCertainDiet(id: Int): List<Diet>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertDiets(diet: MutableCollection<Diet>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCrossRef(link: MutableCollection<CrossRefDietOwnDishes>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertDishes(link: MutableCollection<Dishes>?)

    @Query("SELECT * FROM CrossRefDietOwnDishes")
    abstract suspend fun getCrossRef(): List<CrossRefDietOwnDishes>

    @Entity()
    class Diet(
        @PrimaryKey
        override var dietId: Int = 0,
        override var dietName: String?,
        override var supportingInformation: String?,
        override var duration: Int
    ) : DietModel

    @Entity()
    class Ingredients(
        @PrimaryKey
        var ingredientsId: Int,
        var ingredientsName: String?,
        var protein: Double?,
        var fat: Double?,
        var carbohydrates: Double?,
        var calories: Double?,
        var measure: String?
    )

    @Entity()
    class Dishes(
        @PrimaryKey()
        override var dishesId: Int = 0,
        override var dishesName: String,
        override var protein: Double,
        override var fat: Double,
        override var carbohydrates: Double,
        override var calories: Double,
        override var category: String,
        override var mark: String,
        override var description: String,
        override var linkIngredients: Int = 0
    ) : DishesModel

    @Entity(primaryKeys = ["ownDishesId", "linkIngredientsId"])
    class ListIngredients(
        override var ownDishesId: Int,
        override var linkIngredientsId: Int,
        override var ingredientsCount: Int?,
        override var ingredientsName: String?

    ) : ListIngredientsModel

    @Entity(primaryKeys = ["id_own_diet", "id_link_dishes"])
    class CrossRefDietOwnDishes(
        override val id_own_diet: Int,
        override val id_link_dishes: Int
    ) : CrossRefDietOwnDishesModel


}