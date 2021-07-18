package io.vbytsyuk.example.api.models

import com.squareup.moshi.JsonClass
import io.vbytsyuk.example.core.domain.Character

@JsonClass(generateAdapter = true)
internal data class CharacterResponse(
    val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String,
    val location: LocationResponse,
) : Response<Character> {
    override fun toModel() = Character(
        id = id,
        name = name,
        species = species,
        status = status,
        gender = gender,
        imageUrl = image,
        locationName = location.toModel()
    )

    @JsonClass(generateAdapter = true)
    data class LocationResponse(
        val name: String
    ) : Response<String> {
        override fun toModel(): String = name
    }
}
