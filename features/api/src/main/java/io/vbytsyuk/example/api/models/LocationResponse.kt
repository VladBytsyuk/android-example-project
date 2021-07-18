package io.vbytsyuk.example.api.models

import com.squareup.moshi.JsonClass
import io.vbytsyuk.example.core.domain.Location

@JsonClass(generateAdapter = true)
internal data class LocationResponse(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
) : Response<Location> {
    override fun toModel() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension
    )
}
