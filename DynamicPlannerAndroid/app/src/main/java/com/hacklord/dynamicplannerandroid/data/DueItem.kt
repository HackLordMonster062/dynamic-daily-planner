package com.hacklord.dynamicplannerandroid.data

sealed interface DueItem {
    data class Task(val due: DueDate) : DueItem
    data class Timeline(val list: List<DueItem>, val isOrdered: Boolean, val due: DueDate) : DueItem
    data class Project(val timelines: List<Timeline>, val due: DueDate) : DueItem
}