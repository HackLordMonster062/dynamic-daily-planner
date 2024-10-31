package com.hacklord.dynamicplannerandroid.data

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn
import kotlinx.serialization.Serializable

@Serializable
data class DueDate(
    val date: LocalDate
) {
    fun isOverdue(): Boolean {
        return date < Clock.System.todayIn(TimeZone.currentSystemDefault())
    }

    fun daysRemaining(): Int {
        return Clock.System.todayIn(TimeZone.currentSystemDefault()).daysUntil(date)
    }
}