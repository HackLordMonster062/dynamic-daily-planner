package org.hacklord.dynamic_planner.data

sealed class DueItem(
    val due: DueDate
) {
    class Task(due: DueDate) : DueItem(due)
    class Timeline(val list: List<DueItem>, val isOrdered: Boolean, due: DueDate) : DueItem(due)
    class Project(val timelines: List<Timeline>, due: DueDate) : DueItem(due)
}