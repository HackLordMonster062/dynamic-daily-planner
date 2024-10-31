package com.hacklord.dynamicplannerandroid.data

import com.hacklord.dynamicplannerandroid.data.entity.DueItemEntity
import com.hacklord.dynamicplannerandroid.data.entity.ProjectEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProjectRepositoryImpl(
    val projectDao: ProjectDao,
    val dueItemDao: DueItemDao
) : ProjectRepository {
    override suspend fun insertProject(project: ProjectItem) {
        project.timelines.forEach { timeline ->
            insertDueItem(timeline)
        }

        projectDao.insert(ProjectEntity(
            id = project.entityId,
            title = project.title,
            items = project.timelines.map { it.entityId }
        ))
    }

    override suspend fun deleteProject(id: Int) {
        val project = projectDao.getProjectById(id)

        project?.items?.forEach {
            dueItemDao.delete(it!!)
        }

        projectDao.delete(id)
    }

    override suspend fun insertDueItem(item: DueItem) {
        dueItemDao.insert(DueItemEntity(
            id = item.entityId,
            item = Json.encodeToString(item)
        ))
    }

    override fun getAllProjects(): Flow<List<ProjectItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProjectById(id: Int): ProjectItem? {
        TODO("Not yet implemented")
    }
}