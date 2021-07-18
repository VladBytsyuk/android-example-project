package io.vbytsyuk.example.database.dao

import androidx.room.*
import io.vbytsyuk.example.database.entities.CharacterEntity
import io.vbytsyuk.example.database.entities.LocationEntity

@Dao
internal interface CharacterDao {
    @Query("SELECT * FROM CharacterEntity")
    suspend fun loadAllCharacters(): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(locationsList: List<CharacterEntity>)

    @Query("DELETE FROM CharacterEntity")
    suspend fun clearAll()
}
