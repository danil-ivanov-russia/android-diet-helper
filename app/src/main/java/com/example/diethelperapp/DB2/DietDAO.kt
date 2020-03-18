package com.example.diethelperapp.db2

import androidx.room.*
import com.example.diethelperapp.db2.models.*
import com.example.diethelperapp.db2.relationDataClasses.CalendarWithDishes
import com.example.diethelperapp.db2.relationDataClasses.DietWithDishes

@Dao
abstract class DietDAO {
    @Query("SELECT * FROM Diet")
    abstract suspend fun getAllDiet(): List<Diet>

    @Query("SELECT * FROM Dishes")
    abstract suspend fun getAllDishes(): List<Dishes>

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

    @Query("SELECT * FROM CrossRefDietOwnDishes")
    abstract suspend fun getCrossRefDietWithDishes(): List<CrossRefDietOwnDishes>

    @Query("SELECT * FROM CrossRefCalendarOwnDishes")
    abstract suspend fun getCrossRefCalendarWithDishes(): List<CrossRefCalendarOwnDishes>


    @Transaction
    @Query("SELECT * FROM Diet Where dietId = :id")
    abstract suspend fun getDishesByCertainDiet(id: Int): List<DietWithDishes>

    @Transaction
    @Query("SELECT * FROM Calendar")
    abstract suspend fun getCalendar(): List<CalendarWithDishes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertDiets(diet: MutableCollection<Diet>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCrossRefDietWithDishes(link: MutableCollection<CrossRefDietOwnDishes>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertDishes(link: MutableCollection<Dishes>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCalendar(link: MutableCollection<Calendar>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCrossRefCalendarWithDishes(link: MutableCollection<CrossRefCalendarOwnDishes>?)



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
        var calories: Double?
    )

    @Entity()
    class Dishes(
        @PrimaryKey
        override var dishesId: Int = 0,
        override var dishesName: String,
        override var protein: Double,
        override var fat: Double,
        override var carbohydrates: Double,
        override var calories: Double,
        override var category: String,
        override var mark: List<String>,
        override var description: String,
        override var amount: Int = 1
    ) : DishesModel

    @Entity(primaryKeys = ["ownDishesId", "linkIngredientsId"])
    class ListIngredients(
        override var ownDishesId: Int,
        override var linkIngredientsId: Int,
        override var ingredientsCount: Int?

    ) : ListIngredientsModel

    @Entity(primaryKeys = ["dietId", "dishesId"])
    class CrossRefDietOwnDishes(
        override val dietId: Int,
        override val dishesId: Int
    ) : CrossRefDietOwnDishesModel

    @Entity(primaryKeys = ["markDiet", "dishesId"])
    class CrossRefCalendarOwnDishes(
        override val markDiet: String,
        override val dishesId: Int
    ) : CrossRefCalendarOwnDishesModel

    @Entity()
    class Calendar(
        @PrimaryKey
        override var markDiet: String,
        override val dayOfWeek: String
    ) : ModelCalendar


}