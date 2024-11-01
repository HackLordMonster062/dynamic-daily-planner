package com.hacklord.dynamicplannerandroid.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hacklord.dynamicplannerandroid.data.entity.DueItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DueItemDao {
    @Upsert
    suspend fun insert(item: DueItemEntity)

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM dueitems WHERE id=:id")
    suspend fun getItemById(id: Int): DueItemEntity?

    @Query("SELECT * FROM dueitems")
    fun getItems(): Flow<List<DueItemEntity>>
}