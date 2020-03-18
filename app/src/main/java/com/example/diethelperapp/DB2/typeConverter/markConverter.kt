package com.example.diethelperapp.db2.typeConverter

import androidx.room.TypeConverter
import java.util.*

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromListString(list: List<String>):String = list.joinToString()
// здесь надо чего нибудь покрасивее написать
    @TypeConverter
    @JvmStatic
    fun toListString(tmp: String ): List<String> = tmp.split(",").toList()
}