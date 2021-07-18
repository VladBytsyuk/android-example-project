package io.vbytsyuk.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.vbytsyuk.example.database.entities.EpisodeEntity

@Dao
internal interface EpisodeDao {
    @Query("SELECT * FROM EpisodeEntity")
    suspend fun loadAllEpisodes(): List<EpisodeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(episodesList: List<EpisodeEntity>)

    @Query("DELETE FROM EpisodeEntity")
    suspend fun clearAll()
}
