package com.hacklord.dynamicplannerandroid.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Projects")
data class ProjectEntity(
    @PrimaryKey val id: Int?,
    val title: String,
    val items: List<Int?>
)