package org.hacklord.dynamic_planner.data

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn

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