package com.hacklord.dynamicplannerandroid.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DueItemDao {
    @Upsert
    suspend fun insert(item: DueItem)

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM dueitems WHERE id=:id")
    suspend fun getItemById(id: Int): DueItem?

    @Query("SELECT * FROM dueitems")
    fun getItems(): Flow<List<DueItem>>
}