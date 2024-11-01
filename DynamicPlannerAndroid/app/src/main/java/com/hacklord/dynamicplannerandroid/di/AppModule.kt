package com.hacklord.dynamicplannerandroid.di

import androidx.room.Room
import com.hacklord.dynamicplannerandroid.data.ProjectRepositoryImpl
import com.hacklord.dynamicplannerandroid.data.database.TaskDatabase
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            TaskDatabase::class.java,
            name = "project_db"
        ).build()
    }
    single {
        ProjectRepositoryImpl(
            get<TaskDatabase>().projectDao,
            get<TaskDatabase>().dueItemDao
        )
    }
}