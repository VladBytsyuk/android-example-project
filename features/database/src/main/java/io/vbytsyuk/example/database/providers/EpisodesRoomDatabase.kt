package io.vbytsyuk.example.database.providers

import android.content.Context
import androidx.room.Room
import io.vbytsyuk.example.core.database.domain.EpisodesDatabase
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.database.RoomDatabaseImpl
import io.vbytsyuk.example.database.entities.EpisodeEntity

internal class EpisodesRoomDatabase(applicationContext: Context, databaseName: String) : EpisodesDatabase {
    private val room = Room.databaseBuilder(
        applicationContext,
        RoomDatabaseImpl::class.java,
        databaseName
    ).build()

    override suspend fun loadData(): List<Episode> =
        room.episodeDao.loadAllEpisodes().map(::convertEntityIntoModel)

    override suspend fun saveData(data: List<Episode>) =
        room.episodeDao.saveEpisodes(data.map(::convertModelIntoEntity))

    override suspend fun clear() =
        room.episodeDao.clearAll()

    private fun convertEntityIntoModel(entity: EpisodeEntity): Episode = Episode(
        id = entity.id,
        name = entity.name,
        airDate = entity.airDate,
        episodeCode = entity.episodeCode
    )

    private fun convertModelIntoEntity(model: Episode): EpisodeEntity = EpisodeEntity(
        id = model.id,
        name = model.name,
        airDate = model.airDate,
        episodeCode = model.episodeCode
    )
}
