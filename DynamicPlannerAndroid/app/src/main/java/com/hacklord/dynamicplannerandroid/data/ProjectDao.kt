package com.hacklord.dynamicplannerandroid.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hacklord.dynamicplannerandroid.data.entity.ProjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Upsert
    suspend fun insert(project: ProjectEntity)

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM Projects")
    fun getProjects(): Flow<List<ProjectEntity>>

    @Query("SELECT * FROM Projects WHERE id=:id")
    suspend fun getProjectById(id: Int): ProjectEntity?
}