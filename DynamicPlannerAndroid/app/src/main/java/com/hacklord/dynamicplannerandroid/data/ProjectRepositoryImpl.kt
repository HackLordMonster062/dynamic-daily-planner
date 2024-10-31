package com.hacklord.dynamicplannerandroid.data

import com.hacklord.dynamicplannerandroid.data.entity.DueItemEntity
import com.hacklord.dynamicplannerandroid.data.entity.ProjectEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
        val projects = projectDao.getProjects()
            .map { projectEntities ->
                projectEntities.map { entity ->
                    getProjectById(entity.id!!)!!
                }
            }

        return projects
    }

    override suspend fun getDueItemById(id: Int): DueItem? {
        val item = dueItemDao.getItemById(id)

        item ?: return null

        return Json.decodeFromString(item.item)
    }

    override suspend fun getProjectById(id: Int): ProjectItem? {
        val project = projectDao.getProjectById(id)

        project ?: return null

        return ProjectItem(
            title = project.title,
            timelines = project.items.map { getDueItemById(it!!) as DueItem.Timeline },
            entityId = project.id
        )
    }
}