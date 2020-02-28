package com.example.diethelperapp.diet

import com.example.diethelperapp.DB.DietDAO
import com.example.diethelperapp.DB2.AppDatabase

class DietRepositoryImplementation(private val dao: DietDAO): DietRepository
{
    override suspend fun getAllDiet(): List<DietRepository.Diet> {
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


}