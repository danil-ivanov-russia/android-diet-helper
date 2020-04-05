package com.example.diethelperapp.db2

import androidx.room.*
import com.example.diethelperapp.db2.models.*
import com.example.diethelperapp.db2.relationDataClasses.CalendarWithDishes
import com.example.diethelperapp.db2.relationDataClasses.DietWithDishes
import com.example.diethelperapp.db2.relationDataClasses.OneToOneListToIngredient

@Dao
abstract class DietDAO {
    @Query("SELECT * FROM Diet")
    abstract suspend fun getAllDiet(): List<Diet>

    @Query("SELECT * FROM Dishes")
    abstract suspend fun getAllDishes(): List<Dishes>

    @Query("SELECT * FROM Dishes Where dishesName = :dishesName")
    abstract suspend fun getDishes(dishesName: String): Dishes

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



    @Query("SELECT dishesId FROM Dishes Where dishesName =:name")
    abstract suspend fun getDishesIdByName(name: String): Int

    @Query("SELECT markDiet FROM Calendar Where dayOfWeek =:day")
    abstract suspend fun getMarkDietByDay(day: String): String

    @Query("SELECT currentDiet From User ")
    abstract suspend fun getCurrentDiet(): Int

    @Query("SELECT * From Ingredients ")
    abstract suspend fun getAllIngredient(): List<Ingredients>

    @Query("SELECT * FROM Ingredients Where ingredientsName = :idIngredient")
    abstract suspend fun getCertainIngredientById(idIngredient: String): Ingredients

    @Query("DELETE FROM Calendar ")
    abstract suspend fun deleteCalendar()


    @Transaction
    @Query("SELECT * FROM Diet Where dietId = :id")
    abstract suspend fun getDishesByCertainDiet(id: Int): List<DietWithDishes?>


    @Transaction
    @Query("SELECT * FROM Calendar")
    abstract suspend fun getCalendar(): List<CalendarWithDishes>

    @Transaction
    @Query("SELECT * FROM ListIngredients Where dishesId = :dishesId")
    abstract suspend fun getIngredientsByDishesId(dishesId: Int): List<OneToOneListToIngredient>


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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCrossRefCalendarWithDishes(link: CrossRefCalendarOwnDishes)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertIngredients(link: MutableCollection<Ingredients>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertListIngredients(link: MutableCollection<ListIngredients>?)




    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertUserCurrentDiet(user: User)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun updateDishes(link: Dishes)


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
            var ingredientsName: String,
            var protein: Double?,
            var fat: Double?,
            var carbohydrates: Double?,
            var calories: Double?
    )

    @Entity()
    class Dishes(
            @PrimaryKey(autoGenerate = true)
            override var dishesId: Int = 99,
            override var dishesName: String = "DishesTest",
            override var protein: Double = 10.0,
            override var fat: Double = 10.0,
            override var carbohydrates: Double = 10.0,
            override var calories: Double = 10.0,
            override var category: String = "10.0",
            override var mark: MutableList<String> = mutableListOf("1", "2"),
            override var description: String = "Test",
            override var amount: Int = 1
    ) : DishesModel

    @Entity()
    class ListIngredients(
            @PrimaryKey()
            override var ingredientId: String,
            override var ingredientsCount: Int?,
            override var dishesId: Int

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

    @Entity()
    class User(
            @PrimaryKey
            override val currentDiet: Int
    ) : UserModel


}
/* @Entity()
    class User(
        @PrimaryKey
        override val currentDiet: String
    ): UserModel


*/