package com.hacklord.dynamicplannerandroid.data

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
sealed interface DueItem {
    val due: DueDate
    val title: String
    val entityId: Int?

    @Serializable
    data class Task(
        override val title: String,
        override val due: DueDate,
        override val entityId: Int? = null
    ) : DueItem

    @Serializable
    data class Timeline(
        override val title: String,
        override val due: DueDate,
        val list: List<DueItem>,
        val isOrdered: Boolean,
        override val entityId: Int? = null,
        val currItem: Int = 0,
    ) : DueItem

    fun getTask(): Task {
        when (this) {
            is Task -> {
                return this
            }
            is Timeline -> {
                if (isOrdered)
                    return list[currItem].getTask()

                return list[Random.nextInt(list.size)].getTask()
            }
        }
    }
}