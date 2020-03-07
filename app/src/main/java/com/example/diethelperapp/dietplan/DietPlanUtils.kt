package com.example.diethelperapp.dietplan

import android.content.Context
import androidx.core.os.ConfigurationCompat
import java.text.SimpleDateFormat
import java.util.*


object DietPlanUtils {
    @JvmStatic
    fun getDayOfWeekString(context: Context, day: Int): String? {
        day ?: return null
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar[Calendar.DAY_OF_WEEK] = Calendar.MONDAY
        val days = arrayOfNulls<String>(7)
        for (i in 0..6) {
            days[i] = SimpleDateFormat(
                "EEEE,\nd MMMM",
                ConfigurationCompat.getLocales(context.resources.configuration)[0]
            ).format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        return days[day]
    }

    @JvmStatic
    fun checkIfToday(context: Context, day: Int): Boolean {
        val calendar = Calendar.getInstance()
        return SimpleDateFormat(
            "u",
            ConfigurationCompat.getLocales(context.resources.configuration)[0]
        ).format(calendar.time).toInt() == (day + 1)
    }
}