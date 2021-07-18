package io.vbytsyuk.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.vbytsyuk.example.database.entities.LocationEntity

@Dao
internal interface LocationDao {
    @Query("SELECT * FROM LocationEntity")
    suspend fun loadAllLocations(): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(locationsList: List<LocationEntity>)

    @Query("DELETE FROM LocationEntity")
    suspend fun clearAll()
}
