package com.example.diethelperapp.diet

import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.db2.models.DietModel

class DietRepositoryImplementation(private val dao: DietDAO) : DietRepository {
    override suspend fun getAllDiet(): List<DietDAO.Diet> {
       return dao.getAllDiet()
    }

    override suspend fun getIdCertainDiet(name_certain_diet: String): Int {
      //  return dao.getIdCertainDiet(name_certain_diet)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getNameCertainDiet(id_certain_diet: Int): String {
     //   return dao.getNameCertainDiet(id_certain_diet)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getAllNameDiets(): List<String> {
        return dao.getAllNameDiets()
    }

    override suspend fun getDescriptionCertainDiet(id_certain_diet: Int): String {
     //   return dao.getDescriptionCertainDiet(id_certain_diet)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDurationCertainDiet(id_certain_diet: Int): Int {
     //   return dao.getDurationCertainDiet(id_certain_diet)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getCertainDietById(
        id_certain_diet: Int
    ): DietModel = dao.getCertainDietById(id_certain_diet)

}