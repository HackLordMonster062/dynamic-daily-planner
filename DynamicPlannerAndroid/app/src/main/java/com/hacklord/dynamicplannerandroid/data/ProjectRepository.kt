package com.hacklord.dynamicplannerandroid.data

import kotlinx.coroutines.flow.Flow

interface ProjectRepository {
    suspend fun insertProject(project: ProjectItem)

    suspend fun deleteProject(id: Int)

    suspend fun insertDueItem(item: DueItem)

    fun getAllProjects(): Flow<List<ProjectItem>>

    suspend fun getDueItemById(id: Int): DueItem?

    suspend fun getProjectById(id: Int): ProjectItem?
}