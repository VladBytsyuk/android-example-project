package io.vbytsyuk.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.vbytsyuk.example.database.dao.CharacterDao
import io.vbytsyuk.example.database.dao.EpisodeDao
import io.vbytsyuk.example.database.dao.LocationDao
import io.vbytsyuk.example.database.entities.CharacterEntity
import io.vbytsyuk.example.database.entities.EpisodeEntity
import io.vbytsyuk.example.database.entities.LocationEntity


@Database(
    entities = [LocationEntity::class, CharacterEntity::class, EpisodeEntity::class],
    version = 1
)
internal abstract class RoomDatabaseImpl : RoomDatabase() {
    abstract val locationDao: LocationDao
    abstract val characterDao: CharacterDao
    abstract val episodeDao: EpisodeDao
}
