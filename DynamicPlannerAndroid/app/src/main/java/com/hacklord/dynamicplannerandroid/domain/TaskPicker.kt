package com.hacklord.dynamicplannerandroid.domain

import com.hacklord.dynamicplannerandroid.data.DueItem
import com.hacklord.dynamicplannerandroid.data.DueItem.Task
import com.hacklord.dynamicplannerandroid.data.DueItem.Timeline
import com.hacklord.dynamicplannerandroid.data.ProjectItem
import kotlin.random.Random

class TaskPicker(
    private val projects: List<ProjectItem>,
    private val availableTime: Float
) {
    fun getTasks(): List<Task> {
        val tasks: MutableList<Task> = mutableListOf()

        projects.forEach { project ->
            project.timelines.forEach { timeline ->
                tasks.add(getTaskForDueItem(timeline))
            }
        }

        tasks.sortBy { task ->
            val remainingDays = task.due?.daysRemaining() ?: AppConstants.DEFAULT_DUE_DURATION
            if (remainingDays < AppConstants.URGENT_DUE) return@sortBy remainingDays
            remainingDays + Random.nextInt(10, 20)
        }

        val filteredTasks: MutableList<Task> = mutableListOf()
        var timeAcc = 0f

        tasks.forEach { task ->
            if (timeAcc + task.expectedHours <= availableTime) {
                filteredTasks.add(task)
                timeAcc += task.expectedHours
            }
            else return@forEach
        }

        return filteredTasks
    }

    private fun getTaskForDueItem(dueItem: DueItem): Task {
        when (dueItem) {
            is Task -> {
                return dueItem
            }
            is Timeline -> {
                if (dueItem.isOrdered)
                    return getTaskForDueItem(dueItem.list[dueItem.currItem])

                return getTaskForDueItem(dueItem.list[Random.nextInt(dueItem.list.size)])
            }
        }
    }
}