package io.vbytsyuk.example.api.retrofit

import io.vbytsyuk.example.api.models.CharacterResponse
import io.vbytsyuk.example.api.models.EpisodeResponse
import io.vbytsyuk.example.api.models.ListDataResponse
import io.vbytsyuk.example.api.models.LocationResponse
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.domain.Location
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RetrofitApi {
    @GET("/api/location")
    suspend fun fetchLocations(
        @Query("page") page: Int,
    ): ListDataResponse<Location, LocationResponse>

    @GET("/api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): ListDataResponse<Character, CharacterResponse>

    @GET("/api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int,
    ): ListDataResponse<Episode, EpisodeResponse>
}
