package com.hacklord.dynamicplannerandroid.data

import androidx.room.Entity
import androidx.room.PrimaryKey

typealias Item = String

@Entity(tableName = "DueItems")
data class DueItemEntity(
    @PrimaryKey val id: Int?,
    val item: Item
)
