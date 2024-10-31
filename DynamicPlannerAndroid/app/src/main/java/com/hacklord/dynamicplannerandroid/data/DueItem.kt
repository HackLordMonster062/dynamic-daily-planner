package com.hacklord.dynamicplannerandroid.data

import kotlinx.serialization.Serializable

@Serializable
sealed interface DueItem {
    val due: DueDate
    val title: String

    @Serializable
    data class Task(
        override val title: String,
        override val due: DueDate
    ) : DueItem

    @Serializable
    data class Timeline(
        override val title: String,
        override val due: DueDate,
        val list: List<DueItem>,
        val isOrdered: Boolean,
        val currItem: Int = 0
    ) : DueItem
}