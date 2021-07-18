package io.vbytsyuk.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class EpisodeEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val airDate: String,
    val episodeCode: String,
)
