package com.hacklord.dynamicplannerandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hacklord.dynamicplannerandroid.data.entity.DueItemEntity
import com.hacklord.dynamicplannerandroid.data.entity.ProjectEntity

@Database(
    entities = [DueItemEntity::class, ProjectEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDatabase : RoomDatabase() {
    abstract val projectDao: ProjectDao
    abstract val dueItemDao: DueItemDao
}