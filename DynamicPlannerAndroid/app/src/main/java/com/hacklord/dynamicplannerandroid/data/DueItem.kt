package com.hacklord.dynamicplannerandroid.data

import kotlinx.serialization.Serializable

@Serializable
sealed interface DueItem {
    val due: DueDate?
    val title: String
    val entityId: Int?

    @Serializable
    data class Task(
        override val title: String,
        override val due: DueDate?,
        val expectedHours: Float,
        override val entityId: Int? = null
    ) : DueItem

    @Serializable
    data class Timeline(
        override val title: String,
        override val due: DueDate?,
        val list: List<DueItem>,
        val isOrdered: Boolean,
        override val entityId: Int? = null,
        val currItem: Int = 0,
    ) : DueItem
}