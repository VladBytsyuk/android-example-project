package io.vbytsyuk.example.api.models

import com.squareup.moshi.JsonClass
import io.vbytsyuk.example.core.domain.Episode

@JsonClass(generateAdapter = true)
internal data class EpisodeResponse(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
) : Response<Episode> {
    override fun toModel() = Episode(
        id = id,
        name = name,
        airDate = air_date,
        episodeCode = episode
    )
}
