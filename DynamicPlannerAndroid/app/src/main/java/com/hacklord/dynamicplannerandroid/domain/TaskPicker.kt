package com.hacklord.dynamicplannerandroid.domain

import com.hacklord.dynamicplannerandroid.data.DueItem
import com.hacklord.dynamicplannerandroid.data.DueItem.Task
import com.hacklord.dynamicplannerandroid.data.DueItem.Timeline
import com.hacklord.dynamicplannerandroid.data.ProjectItem
import kotlin.random.Random

class TaskPicker(
    val projects: List<ProjectItem>,
    val availableTime: Float
) {
    fun getTasks(): List<Task> {
        val tasks: MutableList<Task> = mutableListOf()

        projects.forEach { project ->
            project.timelines.forEach { timeline ->
                tasks.add(getTaskForDueItem(timeline))
            }
        }

        tasks.sortBy { task ->
            task.due?.daysRemaining() ?: Random.nextInt(1000, 2000)
        }

        val filteredTasks: MutableList<Task> = mutableListOf()
        var timeAcc = 0f

        tasks.forEach { task ->
            timeAcc += task.expectedHours

            if (timeAcc <= availableTime) filteredTasks.add(task)
            else return@forEach
        }

        return tasks
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